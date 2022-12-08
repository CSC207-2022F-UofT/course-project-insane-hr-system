package use_case.leave_request;

public interface LeaveRequestInputBoundary {
    LeaveRequestResponseModel create(LeaveRequestRequestModel requestModel);
}
