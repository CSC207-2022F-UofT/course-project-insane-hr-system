package complete_task;

import entity.*;

import java.util.Objects;
import java.util.UUID;

public class CompleteTaskInteractor implements CompleteTaskInputBoundary{
    private final CompleteTaskDsGateway completeGateway;
    private final CompleteTaskOutputBoundary completeOutputBoundary;

    public CompleteTaskInteractor(CompleteTaskDsGateway completeGateway,
                                  CompleteTaskOutputBoundary completeOutputBoundary) {
        this.completeGateway = completeGateway;
        this.completeOutputBoundary = completeOutputBoundary;
    }

    @Override
    public CompleteTaskResponseModel create(CompleteTaskRequestModel requestModel) {
        Task task = requestModel.getTask();
        User user = requestModel.getUser();

        if (Objects.equals(requestModel.getTask().getState(), "CLOSED")) {
            return completeOutputBoundary.prepareFailureView("Task already closed!");
        }

        task.setState("CLOSED");

        // create in file saved information
        CompleteTaskDsRequestModel completeTaskDsRequestModel = new CompleteTaskDsRequestModel(task);
        completeGateway.save(completeTaskDsRequestModel);

        // prepare response
        CompleteTaskResponseModel completeResponseModel = new CompleteTaskResponseModel(
                "Submitted successfully!");
        return completeOutputBoundary.prepareSuccessView(completeResponseModel);
    }
}
