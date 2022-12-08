package presenter;
import use_case.evaluate_task.EvaluateTaskOutputBoundary;
import use_case.evaluate_task.EvaluateTaskResponseModel;


public class EvaluateTaskPresenter implements EvaluateTaskOutputBoundary {

    @Override
    public EvaluateTaskResponseModel prepareSuccessView(EvaluateTaskResponseModel response) {
        return response;
    }

    @Override
    public EvaluateTaskResponseModel prepareFailureView(String error) {throw new RuntimeException(error);
    }
}
