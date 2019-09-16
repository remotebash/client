package helpers;

import modal.Computer;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class ComputerHelper {

    private final static SystemInfo SYSTEM_INFO = new SystemInfo();
    private static Computer computer = null;

    public static Computer getComputer() {
        if(computer == null){
            OperatingSystem operatingSystem = SYSTEM_INFO.getOperatingSystem();

            String os = String.format("%1$s %2$s - build %3$s", operatingSystem.getFamily(), operatingSystem.getVersion().getVersion(), operatingSystem.getVersion().getBuildNumber());
            Double memory = Common.parseLong(SYSTEM_INFO.getHardware().getMemory().getTotal());
            String processor = SYSTEM_INFO.getHardware().getProcessor().getName();
            PlatformEnum platform = SystemInfo.getCurrentPlatformEnum();

        }
        return computer;
    }

}
