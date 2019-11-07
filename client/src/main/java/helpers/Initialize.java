package helpers;

import service.QRCodeService;
import service.StatusComputerService;

public class Initialize {

    public static void start() {
        load();
    }

    private static void load() {
        ComputerHelper.getComputer();
        StatusComputerService.computerOnline();
        new QRCodeService().scrAutentic();
    }

}
