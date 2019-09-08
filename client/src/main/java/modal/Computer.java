package modal;

import oshi.PlatformEnum;

public class Computer {

    private String systemOperation;
    private Double memory;
    private String processor;
    private PlatformEnum platform;

    public Computer(String systemOperation, Double memory, String processor, PlatformEnum platform) {
        this.setSystemOperation(systemOperation);
        this.setMemory(memory);
        this.setProcessor(processor);
        this.setPlatform(platform);
    }

    public PlatformEnum getPlatform() {
        return platform;
    }

    private void setPlatform(PlatformEnum platform) {
        this.platform = platform;
    }

    public String setSystemOperation() {
        return systemOperation;
    }

    private void setSystemOperation(String systemOperation) {
        this.systemOperation = systemOperation;
    }

    public Double getMemory() {
        return memory;
    }

    private void setMemory(Double memory) {
        this.memory = memory;
    }

    public String getProcessor() {
        return processor;
    }

    private void setProcessor(String processor) {
        this.processor = processor;
    }
}
