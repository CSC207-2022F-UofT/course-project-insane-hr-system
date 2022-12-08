package controller;

import use_case.project_manager_task_init_use_case.PMTaskInitInputBoundary;
import use_case.project_manager_task_init_use_case.PMTaskInitRequestModel;
import use_case.project_manager_task_init_use_case.PMTaskInitResponseModel;

public class PMTaskInitController {

    final PMTaskInitInputBoundary userInput;

    public PMTaskInitController(PMTaskInitInputBoundary userInput) {
        this.userInput = userInput;
    }

    /** Formats user input into a usable request model for the interactor to create the task
     *
     * @param taskName name of the new task
     * @param taskDescription description of the task
     * @param employeeId uid of the employee to assign the task to
     * @return the response model created from user input
     */

    public PMTaskInitResponseModel create(String taskName, String taskDescription, int employeeId) {
        PMTaskInitRequestModel requestModel = new PMTaskInitRequestModel(taskName, taskDescription, employeeId);
        return userInput.createTask(requestModel);
    }
}
