package project_manager_task_init_use_case;

public class PMTaskInitResponseModel {

    String taskName;
    String taskDescription;
    String nameEmployee;

    public PMTaskInitResponseModel(String taskName, String taskDescription, String nameEmployee) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.nameEmployee = nameEmployee;
    }

    public String getTaskName() { return this.taskName; }

    public String getTaskDescription() { return this.taskDescription; }

    public String getNameEmployee() { return this.nameEmployee; }

}
