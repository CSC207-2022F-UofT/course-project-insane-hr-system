package presenter;
import complete_task.CompleteTaskOutputBoundary;
import complete_task.CompleteTaskResponseModel;

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
