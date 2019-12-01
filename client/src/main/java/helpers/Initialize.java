package helpers;

import service.CommandService;
import service.QRCodeService;
import service.StatusComputerService;

public class Initialize {

	public static void start() {
		load();
		CommandService cmd = new CommandService();
		while (true) {
			try {
				Thread.sleep(ConstantsHelper.TIME_DELAY_MS_GET_COMMAND);
				System.out.println("search commands");
				if (!cmd.searchCommandToExecute()) {
					System.out.println("commands not found");
				} else {
					System.out.println("commands found");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void load() {
		if (ComputerHelper.getComputer().getIdComputer() > 0) {
			StatusComputerService.computerOnline();
			new QRCodeService().scrAutentic();
		} else
			new QRCodeService().scrAutentic();
	}

}
