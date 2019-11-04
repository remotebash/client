package service;

import helpers.ComputerHelper;
import helpers.ConstantsHelper;
import helpers.HttpHelper;

import java.util.Timer;
import java.util.TimerTask;

public class StatusComputerService {


    private static void setComputerOnline(){
    	String jsonObject = "{id: \""+ComputerHelper.getComputer().getIdComputer()+"\"}";
    	HttpHelper http = new HttpHelper();
    	http.requestPost(ConstantsHelper.URL_MICROSERVICE_COMPUTER_ONLINE, jsonObject);
    }

    public static void computerOnline(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    setComputerOnline();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(task, ConstantsHelper.TIME_DELAY_MS, ConstantsHelper.TIME_DELAY_MS);
    }

}
