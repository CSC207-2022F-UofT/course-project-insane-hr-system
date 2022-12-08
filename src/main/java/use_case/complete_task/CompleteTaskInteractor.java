package use_case.complete_task;

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
        UUID taskId = requestModel.getTaskId();
        Task task = completeGateway.getTask(taskId);
        User user = requestModel.getUser();

        if (task.getState().equals("CLOSE")) {
            return completeOutputBoundary.prepareFailureView("Task already closed!");
        }

        // create in file saved information
        CompleteTaskDsRequestModel completeTaskDsRequestModel = new CompleteTaskDsRequestModel(task);
        completeGateway.save(completeTaskDsRequestModel);

        // prepare response
        CompleteTaskResponseModel completeResponseModel = new CompleteTaskResponseModel(
                "Submitted successfully!");
        return completeOutputBoundary.prepareSuccessView(completeResponseModel);
    }
}
