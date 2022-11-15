package LeaveRequest;

import Entity.User;

public class LeaveRequestRequestModel {
    private User user;
    private String message;
    private String leaveType;  // "sick", "vacation", or "paternal"
    private int leaveDays;

    public LeaveRequestRequestModel(User user, String message, String leaveType, int leaveDays) {
        this.user = user;
        this.message = message;
        this.leaveType = leaveType;
        this.leaveDays = leaveDays;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
