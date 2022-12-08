package evaluate_task;

import use_case.evaluate_task.EvaluateTaskResponseModel;

public interface EvaluateTaskOutputBoundary {
    EvaluateTaskResponseModel prepareSuccessView(EvaluateTaskResponseModel response);

    EvaluateTaskResponseModel prepareFailureView(String error);
}
