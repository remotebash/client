package modal;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class Computer {

	private PlatformEnum platform;
	SystemInfo si = new SystemInfo();
	HardwareAbstractionLayer hal = si.getHardware();
	OperatingSystem os = si.getOperatingSystem();

	public OperatingSystem getSystem() {
		return os;
	}

	public PlatformEnum getPlatform() {
		return platform;
	}

	public String getProcessor() {
		return si.getHardware().getProcessor().getName();
	}

	public String getMac() {
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

	public String getIp() {
		return os.getNetworkParams().getIpv4DefaultGateway();
	}

	public double getTotal() {
		return this.toDouble(hal.getMemory().getAvailable());
	}

	public double getAvaible() {
		return this.toDouble(si.getHardware().getMemory().getAvailable());
	}

	public double getUsing() {
		return this.getTotal() - this.getAvaible();
	}

	public int getUsePorcent() {
		return (int) ((this.getUsing() * 100.0) / this.getTotal());
	}

	private double toDouble(long num) {
		return Double.parseDouble(FormatUtil.formatBytes(num).split(" ")[0].replace(",", "."));
	}

	public String getProcName() {
		return hal.getProcessor().getName();
	}

	public int[] getVelocidadeFans() {
		return si.getHardware().getSensors().getFanSpeeds();
	}

	public String getIdProcessadorOSHI() {
		return si.getHardware().getProcessor().getProcessorID();
	}

	public String converterMilliParaHoras(long mi) {
		System.out.println(FormatUtil.formatElapsedSecs(mi));
		return FormatUtil.formatElapsedSecs(mi);
	}

	public String getSerialNumber() {
		return hal.getComputerSystem().getSerialNumber();
	}

	public double getVirtualMemory() {
		return this.toDouble(hal.getMemory().getTotal());
	}
}
