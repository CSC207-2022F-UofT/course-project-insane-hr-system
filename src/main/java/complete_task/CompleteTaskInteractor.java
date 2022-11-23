package complete_task;

public class CompleteTaskInteractor implements CompleteTaskInputBoundary{
    final CompleteTaskDsGateway completeTaskDsGateway;
    final CompleteTaskPresenter completeTaskPresenter;

    public CompleteTaskInteractor(CompleteTaskDsGateway completeTaskDsGateway,
                                  CompleteTaskPresenter completeTaskPresenter) {
        this.completeTaskDsGateway = completeTaskDsGateway;
        this.completeTaskPresenter = completeTaskPresenter;
    }

    @Override
    public CompleteTaskResponseModel create(CompleteTaskRequestModel requestModel) {
        return null;
    }
}
