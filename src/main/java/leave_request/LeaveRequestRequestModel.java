package leave_request;

import entity.User;
import entity.LeaveType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LeaveRequestRequestModel {
    private User user;
    private String message;
    private LeaveType leaveType;  // "sick", "vacation", or "paternal"
    private LocalDate startDate;
    private LocalDate returnDate;  // the day the user returns to work

    public LeaveRequestRequestModel(User user, String message, LeaveType leaveType,
                                    LocalDate startDate, LocalDate returnDate) {
        this.user = user;
        this.message = message;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.returnDate = returnDate;
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

    public int getLeaveDays() {
        return (int) startDate.until(returnDate, ChronoUnit.DAYS);
    }
}
