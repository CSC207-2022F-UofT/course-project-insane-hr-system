package entity.project;

import entity.task.Task;

import java.util.List;

public interface RealProject extends Project {
    boolean addTask(Task task);

    boolean removeTask(Task task);

    List<Task> getTasks();

    void setTasks(List<Task> tasks);

    int getFunds();

    void setFunds(int funds);
}
