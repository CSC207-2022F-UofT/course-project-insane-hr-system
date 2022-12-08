package controller;
import entity.*;
import entity.task.CommonTask;
import entity.user.User;
import use_case.evaluate_task.EvaluateTaskInputBoundary;
import use_case.evaluate_task.EvaluateTaskRequestModel;
import use_case.evaluate_task.EvaluateTaskResponseModel;


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
