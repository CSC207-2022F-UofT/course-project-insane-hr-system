package controller;

import entity.LeaveType;
import entity.User;
import leave_request.LeaveRequestInputBoundary;
import leave_request.LeaveRequestRequestModel;
import leave_request.LeaveRequestResponseModel;

import java.time.LocalDate;

public class LeaveRequestController {
    final LeaveRequestInputBoundary userInput;

    public LeaveRequestController(LeaveRequestInputBoundary userInput) {
        this.userInput = userInput;
    }

    public LeaveRequestResponseModel create(User user, String message, LeaveType leaveType,
                                     LocalDate startDate, LocalDate returnDate) {
        LeaveRequestRequestModel requestModel = new LeaveRequestRequestModel(user, message, leaveType, startDate, returnDate);
        return userInput.create(requestModel);
    }
}
