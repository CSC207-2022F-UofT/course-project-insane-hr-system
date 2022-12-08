package use_case.complete_task;

public interface CompleteTaskOutputBoundary {
    CompleteTaskResponseModel prepareSuccessView(CompleteTaskResponseModel response);
    CompleteTaskResponseModel prepareFailureView(String error);
}
