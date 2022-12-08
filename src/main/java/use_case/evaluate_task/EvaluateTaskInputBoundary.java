package use_case.evaluate_task;

import use_case.complete_task.CompleteTaskRequestModel;

public interface EvaluateTaskInputBoundary {
    EvaluateTaskResponseModel create(EvaluateTaskRequestModel requestModel);
}
