package use_case.project_manager_task_init_use_case;

public class PMTaskInitRequestModel {

    private String taskName;

    private String taskDescription;

    private int employeeId;



    public PMTaskInitRequestModel(String taskName, String taskDescription, int employeeId) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.employeeId = employeeId;
        }



    public String getTaskName() { return this.taskName; }

    public String getTaskDescription() { return this.taskDescription; }

    public int getEmployeeId() { return this.employeeId; }



}
