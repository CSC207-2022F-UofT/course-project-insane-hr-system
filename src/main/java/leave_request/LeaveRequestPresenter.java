package leave_request;

public interface LeaveRequestPresenter {
    LeaveRequestResponseModel prepareSuccessView(LeaveRequestResponseModel user);
    LeaveRequestResponseModel prepareFailureView(String error);
}
