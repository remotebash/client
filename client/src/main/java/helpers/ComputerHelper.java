package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import modal.Computer;
import modal.MacAddress;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.hardware.NetworkIF;
import oshi.software.os.OperatingSystem;
import service.ComputerService;

public class ComputerHelper {

    private final static SystemInfo SYSTEM_INFO = new SystemInfo();
    private static Computer computer = null;

    public static void saveComputer(Computer computer) {
        if(computer == null){
        	OperatingSystem operatingSystem = SYSTEM_INFO.getOperatingSystem();

            String os = String.format("%1$s %2$s - build %3$s", operatingSystem.getFamily(), operatingSystem.getVersion().getVersion(), operatingSystem.getVersion().getBuildNumber());
            Double memory = Common.parseLong(SYSTEM_INFO.getHardware().getMemory().getTotal());
            String processor = SYSTEM_INFO.getHardware().getProcessor().getName();
            PlatformEnum platform = SystemInfo.getCurrentPlatformEnum();
            
            NetworkIF[] networks = SYSTEM_INFO.getHardware().getNetworkIFs();
            
            List<MacAddress> macs = new ArrayList<>();

            for (NetworkIF network : networks) {
            	macs.add(new MacAddress(network.getMacaddr(),
                							network.getDisplayName()));
            }
            
            computer = new Computer();
            computer.setSystemOperation(os);
            computer.setProcessor(processor);
            computer.setMemory(memory);
            computer.setPlatform(platform);
            computer.setMacAddress(macs);
            computer.setIdComputer(9412358);
            
        }
        
        ComputerService computerService = new ComputerService();
        computerService.saveComputer(computer);	
    }
    
    public static Computer getComputer() {
    	if(computer == null) {
    		ComputerService computerService = new ComputerService();
        	NetworkIF[] networks = SYSTEM_INFO.getHardware().getNetworkIFs();
            
            List<MacAddress> macs = new ArrayList<>();

            for (NetworkIF network : networks) {
            	macs.add(new MacAddress(network.getMacaddr(),
                							network.getDisplayName()));
            }
            computer = computerService.getComputer(macs);	
    	}
    	return computer;
    }

}
