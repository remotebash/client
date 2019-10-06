package service;

import java.util.List;

import com.google.gson.Gson;

import helpers.ConstantsHelper;
import helpers.HttpHelper;
import modal.Computer;
import modal.MacAddress;

public class ComputerService {
	
	HttpHelper helper;
	
	public Computer getComputer(List<MacAddress> macs) {
		helper = new HttpHelper();
		String response = "";
		Gson gson = new Gson();
		for(MacAddress mac : macs) {
			response = helper.requestGet(ConstantsHelper.URL_REST+"computer/mac/"+mac.getMac());
			Computer computerResponse = new Computer(); 
			
			try {
				computerResponse = gson.fromJson(response, Computer.class);
				if(computerResponse.getIdComputer() > 0)
					return computerResponse;
			}catch(Exception ex) {}
				
		}		
		return null;
	}
	
	public void saveComputer(Computer computer) {
		//TODOs
	}
	
}
