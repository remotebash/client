package modal;

public class Computer {

	private Long id;
	private String macaddress;
	private String ip;
	private String operationalSystem;
	private String ramMemory;
	private String hdTotal;
	private String hdUsage;
	private String processorModel;

	public Computer(String macaddress, String ip, String operationalSystem, String ramMemory, String hdTotal,
			String hdUsage, String processorModel) {
		super();
		this.macaddress = macaddress;
		this.ip = ip;
		this.operationalSystem = operationalSystem;
		this.ramMemory = ramMemory;
		this.hdTotal = hdTotal;
		this.hdUsage = hdUsage;
		this.processorModel = processorModel;
	}

	public Computer() {
	}

	public Long getIdComputer() {
		return id;
	}

	public void setIdComputer(Long idComputer) {
		this.id = idComputer;
	}

	
	public String getMacaddress() {
		return macaddress;
	}

	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOperationalSystem() {
		return operationalSystem;
	}

	public void setOperationalSystem(String operationalSystem) {
		this.operationalSystem = operationalSystem;
	}

	public String getRamMemory() {
		return ramMemory;
	}

	public void setRamMemory(String ramMemory) {
		this.ramMemory = ramMemory;
	}

	public String getHdTotal() {
		return hdTotal;
	}

	public void setHdTotal(String hdTotal) {
		this.hdTotal = hdTotal;
	}

	public String getHdUsage() {
		return hdUsage;
	}

	public void setHdUsage(String hdUsage) {
		this.hdUsage = hdUsage;
	}

	public String getProcessorModel() {
		return processorModel;
	}

	public void setProcessorModel(String processorModel) {
		this.processorModel = processorModel;
	}

}
