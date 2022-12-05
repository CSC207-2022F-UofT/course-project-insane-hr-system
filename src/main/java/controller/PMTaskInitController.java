package controller;

import entity.CommonProject;
import project_manager_task_init_use_case.PMTaskInitInputBoundary;
import project_manager_task_init_use_case.PMTaskInitRequestModel;
import project_manager_task_init_use_case.PMTaskInitResponseModel;

public class PMTaskInitController {

    final PMTaskInitInputBoundary userInput;

    public PMTaskInitController(PMTaskInitInputBoundary userInput) {
        this.userInput = userInput;
    }

    public PMTaskInitResponseModel create(String taskName, String taskDescription, int employeeId) {
        PMTaskInitRequestModel requestModel = new PMTaskInitRequestModel(taskName, taskDescription, employeeId);
        return userInput.createTask(requestModel);
    }
}