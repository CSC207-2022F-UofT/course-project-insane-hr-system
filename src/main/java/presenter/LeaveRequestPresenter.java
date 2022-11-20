package presenter;

import leave_request.LeaveRequestOutputBoundary;
import leave_request.LeaveRequestResponseModel;

public class LeaveRequestPresenter implements LeaveRequestOutputBoundary {

    @Override
    public LeaveRequestResponseModel prepareSuccessView(LeaveRequestResponseModel user) {
        return null;
    }

    @Override
    public LeaveRequestResponseModel prepareFailureView(String error) {
        return null;
    }
}
