package leave_request;

import entity.LeaveType;

import java.time.LocalDate;

public class LeaveRequestResponseModel {
    private LeaveType leaveType;
    private LocalDate startDate;
    private LocalDate returnDate;
    private String createTime;

    public LeaveRequestResponseModel(LeaveType leaveType, LocalDate startDate, LocalDate returnDate, String createTime) {
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.createTime = createTime;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
