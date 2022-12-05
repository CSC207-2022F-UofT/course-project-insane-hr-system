package controller;
import entity.*;
import complete_task.CompleteTaskInputBoundary;
import complete_task.CompleteTaskRequestModel;
import complete_task.CompleteTaskResponseModel;

public class CompleteTaskController {
    final CompleteTaskInputBoundary userInput;

    public CompleteTaskController(CompleteTaskInputBoundary userInput) {
        this.userInput = userInput;
    }

    public CompleteTaskResponseModel create(Task task, User user) {
        CompleteTaskRequestModel requestModel = new CompleteTaskRequestModel(task, user);
        return userInput.create(requestModel);
    }
}
