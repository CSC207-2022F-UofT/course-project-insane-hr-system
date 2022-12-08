package use_case.complete_task;

public interface CompleteTaskInputBoundary {
    CompleteTaskResponseModel create(CompleteTaskRequestModel requestModel);
}
