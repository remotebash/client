package service;

import java.util.List;

import com.google.gson.Gson;

import helpers.ConstantsHelper;
import helpers.HttpHelper;
import modal.Computer;

public class ComputerService {
	
	HttpHelper helper;
	
	public Computer getComputer(List<String> macs) {
		helper = new HttpHelper();
		String response = "";
		Gson gson = new Gson();
		
		String macsRequest = gson.toJson(macs).replace("[", "").replace("]", "");		
		response = helper.requestGet(ConstantsHelper.URL_REST+"computers/"+macsRequest);
		
		return gson.fromJson(response, Computer.class); 
	}
}
