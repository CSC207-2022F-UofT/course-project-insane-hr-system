package controller;
import entity.*;
import complete_task.CompleteTaskInputBoundary;
import complete_task.CompleteTaskRequestModel;
import complete_task.CompleteTaskResponseModel;

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
