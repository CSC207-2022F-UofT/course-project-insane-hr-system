package controller;
import entity.*;
import evaluate_task.EvaluateTaskInputBoundary;
import evaluate_task.EvaluateTaskRequestModel;
import evaluate_task.EvaluateTaskResponseModel;

public class EvaluateTaskController {
    final EvaluateTaskInputBoundary userInput;

    public EvaluateTaskController(EvaluateTaskInputBoundary userinput) {
        this.userInput = userinput;
    }

    public EvaluateTaskResponseModel create(CommonTask commontask, User user, Integer star, String message) {
        EvaluateTaskRequestModel requestModel = new EvaluateTaskRequestModel(commontask, user, star, message);
        return userInput.create(requestModel);
    }
}
