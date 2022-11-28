package presenter;
import evaluate_task.EvaluateTaskOutputBoundary;
import evaluate_task.EvaluateTaskResponseModel;

public class EvaluateTaskPresenter implements EvaluateTaskOutputBoundary{

    @Override
    public EvaluateTaskResponseModel prepareSuccessView(EvaluateTaskResponseModel response) {
        return response;
    }

    @Override
    public EvaluateTaskResponseModel prepareFailureView(String error) {
        return null;
    }
}
