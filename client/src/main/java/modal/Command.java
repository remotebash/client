package modal;

import java.util.Date;

public class Command {

    private String idCommand;
    private long idComputer;
    private String operationalSystem;
    private String command;
    private String result;
    private Date start;
    private Date end;
    private long userId;
    private boolean isExecuted;

    public Command() {}

    public Command(String idCommand, String operationalSystem, String command, Date start, Date end, long userId, long idComputer, boolean isExecuted) {
        this.idCommand = idCommand;
        this.operationalSystem = operationalSystem;
        this.command = command;
        this.start = start;
        this.end = end;
        this.userId = userId;
        this.idComputer = idComputer;
        this.isExecuted = isExecuted;
    }

    public String getIdCommand() {
        return idCommand;
    }

    public void setIdCommand(String idCommand) {
        this.idCommand = idCommand;
    }

    public String getOperationSystem() {
        return operationalSystem;
    }

    public void setOperationSystem(String operationalSystem) {
        this.operationalSystem = operationalSystem;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public void setIsExecuted(boolean isExecuted) {
        this.isExecuted = isExecuted;
    }
}
