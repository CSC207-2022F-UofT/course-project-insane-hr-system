package evaluate_task;

import entity.*;

import complete_task.CompleteTaskRequestModel;

public class EvaluateTaskInteractor implements EvaluateTaskInputBoundary{
    private final EvaluateTaskDsGateway evaluateGateway;
    private final EvaluateTaskOutputBoundary evaluateOutputBoundary;


    public EvaluateTaskInteractor(EvaluateTaskDsGateway evaluateGateway,
                                  EvaluateTaskOutputBoundary evaluateOutputBoundary) {
        this.evaluateGateway = evaluateGateway;
        this.evaluateOutputBoundary = evaluateOutputBoundary;
    }

    @Override
    public EvaluateTaskResponseModel create(CompleteTaskRequestModel requestModel) {
        Task task = requestModel.getTask();
        User employee = requestModel.getUser();


        EvaluateTaskResponseModel evaluateResponseModel = new EvaluateTaskResponseModel(employee,
                "Evaluated successfully!");
        return evaluateOutputBoundary.prepareSuccessView(evaluateResponseModel);
    }
}
