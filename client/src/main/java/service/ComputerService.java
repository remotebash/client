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
		
		String request = "search/computers?";
		for(String mac : macs) {
			request += "macAddressList="+mac+"&";
		}
		request = request.substring(0, request.length() - 1);
		response = helper.requestGet(ConstantsHelper.URL_REST+request);
		
		return gson.fromJson(response, Computer.class);
	}
}
