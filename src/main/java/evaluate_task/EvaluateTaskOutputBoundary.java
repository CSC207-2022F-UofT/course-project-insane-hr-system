package evaluate_task;

public interface EvaluateTaskOutputBoundary {
    EvaluateTaskResponseModel prepareSuccessView(EvaluateTaskResponseModel response);

    EvaluateTaskOutputBoundary prepareFailureView(String error);
}
