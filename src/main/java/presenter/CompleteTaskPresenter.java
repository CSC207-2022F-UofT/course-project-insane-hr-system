package presenter;
import use_case.complete_task.CompleteTaskOutputBoundary;
import use_case.complete_task.CompleteTaskResponseModel;

public class CompleteTaskPresenter implements CompleteTaskOutputBoundary{
    @Override
    public CompleteTaskResponseModel prepareSuccessView(CompleteTaskResponseModel response) {
        return response;
    }

    @Override
    public CompleteTaskResponseModel prepareFailureView(String error) {
        throw new RuntimeException(error);
    }
}
