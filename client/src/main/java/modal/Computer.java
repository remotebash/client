package modal;

import oshi.PlatformEnum;

import java.util.List;
import java.util.UUID;

public class Computer {

    private long idComputer;
    private String systemOperation;
    private Double memory;
    private String processor;
    private PlatformEnum platform;
    private List<MacAddress> macAddress;

    public Computer() { }
    
    public List<MacAddress> getMacAddress() {
		return this.macAddress;
	}

	public void setMacAddress(List<MacAddress> macAddress) {
		this.macAddress = macAddress;
	}

	public String getSystemOperation() {
		return systemOperation;
	}

	public void setIdComputer(long idComputer) {
		this.idComputer = idComputer;
	}

	public long getIdComputer() {
    	return this.idComputer;
    }
    
    public PlatformEnum getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformEnum platform) {
        this.platform = platform;
    }

    public void setSystemOperation(String systemOperation) {
        this.systemOperation = systemOperation;
    }

    public Double getMemory() {
        return memory;
    }

    public void setMemory(Double memory) {
        this.memory = memory;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }
}
