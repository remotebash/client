package service;

import helpers.ConstantsHelper;

import java.util.Timer;
import java.util.TimerTask;

public class StatusComputerService {


    private static void setComputerOnline(){ System.out.println(ConstantsHelper.URL_MICROSERVICE_COMPUTER_ONLINE); }

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
