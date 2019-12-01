package io;

import modal.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class PromptIO {

    public Command exec(Command command) {
    	if(command.getOperationSystem().toLowerCase().contains("windows"))
    		return execOnWindows(command);
    	
    	return updateCommandToSystemNotSupported(command);
    }
    
    private Command updateCommandToSystemNotSupported(Command command) {
    	 command.setResult("System not supported");
    	 command.setEnd(new Date());
    	 command.setIsExecuted(true);
    	 return command;    	
    }

    private Command execOnWindows(Command command) {
    	BufferedReader read = null;
    	try {
    		StringBuilder stringBuilder = new StringBuilder();
    		Process proc = Runtime.getRuntime().exec(command.getCommand());
    	    read = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
    		
    	    String line = "";
    	    while ((line = read.readLine()) != null) {
    	    	stringBuilder.append(line+System.lineSeparator());
    	    }
    	    
            System.err.println(stringBuilder.toString());
            command.setResult(stringBuilder.toString());
            command.setEnd(new Date());
            command.setIsExecuted(true);
            read.close();
            return command;
        } catch (Exception e) {
        	if(read != null) {
        		try {
					read.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	}
            e.printStackTrace();
        }       
    	return command;
    }
}
