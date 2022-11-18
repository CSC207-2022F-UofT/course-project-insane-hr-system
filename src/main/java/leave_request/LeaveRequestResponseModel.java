package leave_request;

public class LeaveRequestResponseModel {
    private String leaveType;
    private int leaveDays;
    private String createTime;

    public LeaveRequestResponseModel(String leaveType, int leaveDays, String createTime) {
        this.leaveType = leaveType;
        this.leaveDays = leaveDays;
        this.createTime = createTime;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
