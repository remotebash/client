package helpers;

import service.StatusComputerService;

public class Initialize {

    public static void start() {
        load();
    }

    private static void load() {
        new ComputerHelper();
        StatusComputerService.computerOnline();
    }

}
