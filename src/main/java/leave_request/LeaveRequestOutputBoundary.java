package leave_request;

public interface LeaveRequestOutputBoundary {
    LeaveRequestResponseModel prepareSuccessView(LeaveRequestResponseModel user);
    LeaveRequestResponseModel prepareFailureView(String error);
}
