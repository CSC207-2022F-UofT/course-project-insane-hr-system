package presenter;

import leave_request.LeaveRequestOutputBoundary;
import leave_request.LeaveRequestResponseModel;

public class LeaveRequestPresenter implements LeaveRequestOutputBoundary {

    @Override
    public LeaveRequestResponseModel prepareSuccessView(LeaveRequestResponseModel response) {
        return response;
    }

    @Override
    public LeaveRequestResponseModel prepareFailureView(String error) {
        throw new RuntimeException(error);
    }
}
