package LeaveRequest;

public class LeaveRequestResponseModel {
    private String leaveType;
    private int leaveDays;
    private String creationTime;

    public LeaveRequestResponseModel(String leaveType, int leaveDays, String creationTime) {
        this.leaveType = leaveType;
        this.leaveDays = leaveDays;
        this.creationTime = creationTime;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
