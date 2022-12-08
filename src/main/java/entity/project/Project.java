package entity.project;

import entity.Department;
import entity.Organization;
import entity.task.Task;

import java.util.List;

public interface Project extends Organization {
    boolean addTask(Task task);

    boolean removeTask(Task task);

    List<Task> getTasks();

    void setTasks(List<Task> tasks);

    String getType();

    Department getDpt();

    void setDpt(Department dpt);
}
