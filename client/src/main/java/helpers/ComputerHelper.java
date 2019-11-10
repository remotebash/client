package helpers;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import modal.Computer;
import oshi.SystemInfo;
import oshi.hardware.NetworkIF;
import oshi.software.os.OperatingSystem;
import service.ComputerService;

public class ComputerHelper {

	private final static SystemInfo SYSTEM_INFO = new SystemInfo();
	private static Computer computer = null;

	public static Computer getComputer() {
		if (computer == null) {
			OperatingSystem operatingSystem = SYSTEM_INFO.getOperatingSystem();

			String os = String.format("%1$s %2$s - build %3$s", operatingSystem.getFamily(),
					operatingSystem.getVersion().getVersion(), operatingSystem.getVersion().getBuildNumber());
			Double memory = Common.parseLong(SYSTEM_INFO.getHardware().getMemory().getTotal());
			String processor = SYSTEM_INFO.getHardware().getProcessor().getName();
			String mac = getMac();
			computer = new Computer(mac, "192.168.0.9", os, memory.toString(), "500GB", "100GB", processor);

		}
		return computer;
	}

	public static String getMac() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			NetworkInterface ni = NetworkInterface.getByInetAddress(address);
			byte[] mac = ni.getHardwareAddress();
			String macAddress = "";
			for (int i = 0; i < mac.length; i++) {
				macAddress += (String.format("%02X-", mac[i]));
			}
			return (macAddress.substring(0, macAddress.length() - 1));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return null;
	}

}
