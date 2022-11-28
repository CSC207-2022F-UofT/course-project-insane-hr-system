package evaluate_task;

import complete_task.CompleteTaskRequestModel;

public interface EvaluateTaskInputBoundary {
    EvaluateTaskResponseModel create(CompleteTaskRequestModel requestModel);
}
