package use_case.complete_task;

import java.util.UUID;

import entity.task.Task;

public interface CompleteTaskDsGateway {
    void save(CompleteTaskDsRequestModel requestModel);

    Task getTask(UUID oid);
}
