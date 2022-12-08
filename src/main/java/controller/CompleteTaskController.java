package controller;

import entity.user.User;
import use_case.complete_task.CompleteTaskInputBoundary;
import use_case.complete_task.CompleteTaskRequestModel;
import use_case.complete_task.CompleteTaskResponseModel;

import java.util.UUID;


public class CompleteTaskController {
    final CompleteTaskInputBoundary userInput;

    public CompleteTaskController(CompleteTaskInputBoundary userInput) {
        this.userInput = userInput;
    }

    public CompleteTaskResponseModel create(UUID taskId, User user) {
        CompleteTaskRequestModel requestModel = new CompleteTaskRequestModel(taskId, user);
        return userInput.create(requestModel);
    }
}
