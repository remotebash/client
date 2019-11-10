package helpers;

import service.QRCodeService;
import service.StatusComputerService;

public class Initialize {

    public static void start() {
    	load();
    	CommandService cmd = new CommandService();
    	//while(true) {
    	System.out.println("search commands");
    		if(!cmd.searchCommandToExecute()) {
    			try {
    				System.out.println("commands not found");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}else {    		
    			System.out.println("commands found");
    		}
    	//}
    }

    private static void load() {
        ComputerHelper.getComputer();
        StatusComputerService.computerOnline();
        new QRCodeService().scrAutentic();
    }

}
