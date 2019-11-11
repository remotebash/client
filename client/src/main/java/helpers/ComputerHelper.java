package helpers;

import java.util.ArrayList;
import java.util.List;

import modal.Computer;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;
import service.ComputerService;

public class ComputerHelper {

	private final static SystemInfo SYSTEM_INFO = new SystemInfo();
	private static Computer computer = null;

	public static Computer getComputer() {
		if (computer == null) {
			List<String> macs = getMac();
			
			ComputerService computerService = new ComputerService();
			Computer computerSaved = computerService.getComputer(macs);
			
			if(computerSaved != null) {			
				computer = computerSaved;
			}else {
				OperatingSystem operatingSystem = SYSTEM_INFO.getOperatingSystem();

				String os = String.format("%1$s %2$s - build %3$s", operatingSystem.getFamily(),
						operatingSystem.getVersion().getVersion(), operatingSystem.getVersion().getBuildNumber());
				Double memory = Common.parseLong(SYSTEM_INFO.getHardware().getMemory().getTotal());
				String processor = SYSTEM_INFO.getHardware().getProcessor().getName();
				
				computer = new Computer(macs, "192.168.0.9", os, memory.toString(), "500GB", "100GB", processor);
			}
		}
		return computer;
	}

	public static List<String> getMac() {
		
		int index = SYSTEM_INFO.getHardware().getNetworkIFs().length;
		List<String> macs = new ArrayList<>();

		for (int i = 0; i < index; i++) {
			if(!SYSTEM_INFO.getHardware().getNetworkIFs()[i].getDisplayName().toLowerCase().contains("virtual")) {
				macs.add(SYSTEM_INFO.getHardware().getNetworkIFs()[i].getMacaddr());				
			}
		}
		
		return macs;
	}

}
