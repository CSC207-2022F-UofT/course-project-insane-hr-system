package add_remove_task_to_project;

import entity.Department;
import entity.Project;
import entity.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class TaskToProjectRequestModel {
    Project project;
    Task toDo;
    boolean toAdd;

    public Project getProject() {
        return project;
    }
    public boolean getToAdd() {
        return toAdd;
    }

    public Task getToDo() {
        return toDo;
    }
}
