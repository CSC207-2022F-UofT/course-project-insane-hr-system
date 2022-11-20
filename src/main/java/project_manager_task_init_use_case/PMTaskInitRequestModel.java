package project_manager_task_init_use_case;

import entity.CommonProject;
import entity.CommonUser;

public class PMTaskInitRequestModel {

    private String taskName;

    private String taskDescription;

    private int employeeId;

    private CommonProject project;

    public PMTaskInitRequestModel(String taskName, String taskDescription, int employeeId, CommonProject project) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.employeeId = employeeId;
        this.project = project;
    }

    public String getTaskName() { return this.taskName; }

    public String getTaskDescription() { return this.taskDescription; }

    public int getEmployeeId() { return this.employeeId; }

    public CommonProject getProject() { return this.project; }

}
