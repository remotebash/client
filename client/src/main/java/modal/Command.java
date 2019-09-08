package modal;

import oshi.PlatformEnum;

import java.util.Date;

public class Command {
    private PlatformEnum platform;
    private String command;
    private StringBuilder result;
    private Date start;
    private Date end;
    private String whoExcuted;

    public Command(PlatformEnum platform, String command, Date start, String whoExcuted) {
        this.setPlatform(platform);
        this.setCommand(command);
        this.setStart(start);
        this.setWhoExcuted(whoExcuted);
        result = new StringBuilder();
    }

    public PlatformEnum getPlatform() {
        return platform;
    }

    public String getCommand() {
        return command;
    }

    public String getResult() {
        return result.toString();
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getWhoExcuted() {
        return this.whoExcuted;
    }

    private void setPlatform(PlatformEnum platform) {
        this.platform = platform;
    }

    private void setCommand(String command) {
        this.command = command;
    }

    public void setResult(String result) {
        this.result.append(result).append("\n");
    }

    private void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    private void setWhoExcuted(String whoExcuted) {
        this.whoExcuted = whoExcuted;
    }

}
