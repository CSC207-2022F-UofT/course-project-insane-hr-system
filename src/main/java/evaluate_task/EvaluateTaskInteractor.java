package evaluate_task;

import entity.*;


public class EvaluateTaskInteractor implements EvaluateTaskInputBoundary{
    private final EvaluateTaskDsGateway evaluateGateway;
    private final EvaluateTaskOutputBoundary evaluateOutputBoundary;


    public EvaluateTaskInteractor(EvaluateTaskDsGateway evaluateGateway,
                                  EvaluateTaskOutputBoundary evaluateOutputBoundary) {
        this.evaluateGateway = evaluateGateway;
        this.evaluateOutputBoundary = evaluateOutputBoundary;
    }

    @Override
    public EvaluateTaskResponseModel create(EvaluateTaskRequestModel requestModel) {
        User employee = requestModel.getUser();
        CommonTask commontask = requestModel.getCommonTask();
        int star = requestModel.getStar();

        if (star < 0) {
            return evaluateOutputBoundary.prepareFailureView("Star cannot be less than 0");
        }
        commontask.setStar(star);

        EvaluateTaskResponseModel evaluateResponseModel = new EvaluateTaskResponseModel(star, employee,
                "Evaluated Successfully!");
        return evaluateOutputBoundary.prepareSuccessView(evaluateResponseModel);
    }

}
