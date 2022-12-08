package use_case.leave_request;

public interface LeaveRequestOutputBoundary {
    LeaveRequestResponseModel prepareSuccessView(LeaveRequestResponseModel response);
    LeaveRequestResponseModel prepareFailureView(String error);
}
