package modal;

import oshi.PlatformEnum;

import java.util.Date;

public class Command {

    private long idCommand;
    private long idComputer;
    private PlatformEnum platform;
    private String command;
    private StringBuilder result;
    private Date start;
    private Date end;
    private String whoExcuted;
    private boolean isExecuted;

    public Command() {
        this.result = new StringBuilder();
    }

    public Command(long idCommand, PlatformEnum platform, String command, Date start, Date end, String whoExcuted, long idComputer, boolean isExecuted) {
        this.idCommand = idCommand;
        this.platform = platform;
        this.command = command;
        this.result = new StringBuilder();
        this.start = start;
        this.end = end;
        this.whoExcuted = whoExcuted;
        this.idComputer = idComputer;
        this.isExecuted = isExecuted;
    }

    public long getIdCommand() {
        return idCommand;
    }

    public void setIdCommand(long idCommand) {
        this.idCommand = idCommand;
    }

    public PlatformEnum getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformEnum platform) {
        this.platform = platform;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public StringBuilder getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result.append(result+"\n");
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getWhoExcuted() {
        return whoExcuted;
    }

    public void setWhoExcuted(String whoExcuted) {
        this.whoExcuted = whoExcuted;
    }

    public long getIdComputer() {
        return idComputer;
    }

    public void setIdComputer(long idComputer) {
        this.idComputer = idComputer;
    }

    public boolean isExecuted() {
        return isExecuted;
    }

    public void setExecuted(boolean executed) {
        isExecuted = executed;
    }
}
