package helpers;

import service.CommandService;
import service.QRCodeService;
import service.StatusComputerService;

public class Initialize {

	public static void start() {
		load();
		CommandService cmd = new CommandService();
		while (true) {
			System.out.println("search commands");
			if (!cmd.searchCommandToExecute()) {
				try {
					System.out.println("commands not found");
					Thread.sleep(ConstantsHelper.TIME_DELAY_MS_GET_COMMAND);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("commands found");
			}
		}
	}

	private static void load() {
		if(ComputerHelper.getComputer().getIdComputer() > 0) {
			StatusComputerService.computerOnline();
			new QRCodeService().scrAutentic();			
		}
		else
			new QRCodeService().scrAutentic();
	}

}
