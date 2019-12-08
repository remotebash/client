package helpers;

import service.CommandService;
import service.QRCodeService;
import service.StatusComputerService;

public class Initialize {

	public static void start() {
		load();
		QRCodeService qrservice = new QRCodeService();
		qrservice.scrTray();
		int aux = 0;
		CommandService cmd = new CommandService();
		if (ComputerHelper.getComputer().getIdComputer() <= 0) {
			aux = 0;
		} else {
			aux = 2;
		}
		while (true) {
			try {
				System.out.println("search commands");
				if (aux == 1) {
					if (ComputerHelper.getComputer().getIdComputer() <= 0) {
						aux = 0;
					}
				} else {
					if (ComputerHelper.getComputer().getIdComputer() > 0 && aux == 2) {
						qrservice.scrQRCode().dispose();
						qrservice.scrQRCode().setVisible(false);
						qrservice.scrInfos().setVisible(true);
						aux = 1;
					} else {
						if (aux == 2) {
						} else {
							qrservice.scrQRCode().setVisible(true);
							aux = 2;
						}
					}
				}
				if (!cmd.searchCommandToExecute()) {
					Thread.sleep(ConstantsHelper.TIME_DELAY_MS_GET_COMMAND);
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
		}

	}

}
