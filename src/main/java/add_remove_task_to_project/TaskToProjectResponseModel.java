package add_remove_task_to_project;

import entity.Project;
import entity.Task;

import java.util.List;

public class TaskToProjectResponseModel {
    Project project;
    boolean succeed;

    public TaskToProjectResponseModel(Project project, boolean succeed) {
        this.project = project;
        this.succeed = succeed;
    }

    public Project getProject() {
        return project;
    }

    public boolean getSucceed() {
        return succeed;
    }
}
