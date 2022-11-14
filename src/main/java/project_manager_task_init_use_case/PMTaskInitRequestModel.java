package project_manager_task_init_use_case;

public class PMTaskInitRequestModel {

    private String taskName;

    private String taskDescription;

    private String nameEmployee;

    public PMTaskInitRequestModel(String taskName, String taskDescription, String nameEmployee) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public String getTaskName() { return this.taskName; }

    public String getTaskDescription() { return this.taskDescription; }

    public  String getNameEmployee() { return this.nameEmployee; }

}
