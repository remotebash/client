package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import helpers.ComputerHelper;
import helpers.ConstantsHelper;
import helpers.HttpHelper;
import io.PromptIO;
import modal.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandService {

	private PromptIO promptIO;
	private HttpHelper http;
	private Gson gson;

	private List<Command> getCommandsToExecute(){
        http = new HttpHelper();
        String jsonCommands = http.requestGet(ConstantsHelper.URL_MICROSERVICE_COMMAND+"command/computer/"+ ComputerHelper.getComputer().getIdComputer());

        if(jsonCommands.length() > 0){
            gson = new Gson();
            return gson.fromJson(jsonCommands, new TypeToken<List<Command>>(){}.getType());
        }

        return new ArrayList<>();
    }

    private void executeCommand(Command command){
        Command executeCommand = promptIO.exec(command);
        gson = new Gson();
        http = new HttpHelper();
        String jsonObject = gson.toJson(executeCommand);
        http.requestPut(ConstantsHelper.URL_MICROSERVICE_COMMAND+"command/", jsonObject);
    }

	public boolean searchCommandToExecute() {
		List<Command> commandsToExecute = getCommandsToExecute();
		if (commandsToExecute.size() > 0) {
			promptIO = new PromptIO();
			commandsToExecute.forEach(command -> {
				executeCommand(command);
			});
			return true;
		}
		return false;
	}

}
