package leave_request;

public class LeaveRequestResponseModel {
    private String leaveType;
    private String startDate;
    private String returnDate;
    private String createTime;

    public LeaveRequestResponseModel(String leaveType, String startDate, String returnDate, String createTime) {
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.createTime = createTime;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
