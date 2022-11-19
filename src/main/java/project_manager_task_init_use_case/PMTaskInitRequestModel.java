package project_manager_task_init_use_case;

import entity.CommonProject;
import entity.CommonUser;

public class PMTaskInitRequestModel {

    private String taskName;

    private String taskDescription;

    private CommonUser employee;

    private CommonProject project;

    private

    public PMTaskInitRequestModel(String taskName, String taskDescription, CommonUser employee, CommonProject project) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.employee = employee;
        this.project = project;
    }

    public String getTaskName() { return this.taskName; }

    public String getTaskDescription() { return this.taskDescription; }

    public CommonUser getEmployee() { return this.employee; }

    public CommonProject getProject() { return this.project; }

}
