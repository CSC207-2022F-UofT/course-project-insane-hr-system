package use_case.project_manager_task_init_use_case;

public class PMTaskInitResponseModel {

    String taskName;
    String taskDescription;

    int employeeId;

    public PMTaskInitResponseModel(String taskName, String taskDescription, int emmployeeId) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.employeeId = emmployeeId;
    }

    public String getTaskName() { return this.taskName; }

    public String getTaskDescription() { return this.taskDescription; }

    public int getEmployeeId() { return this.employeeId; }

}
