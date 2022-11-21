package complete_task;

import leave_request.LeaveRequestResponseModel;

public interface CompleteTaskOutputBoundary {
    CompleteTaskResponseModel prepareSuccessView(CompleteTaskResponseModel response);
    CompleteTaskResponseModel prepareFailureView(String error);
}
