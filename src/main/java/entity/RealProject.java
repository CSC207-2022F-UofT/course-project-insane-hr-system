package entity;

import java.util.List;

public interface RealProject extends Project {
    boolean addTask(Task task);

    boolean removeTask(Task task);

    int getStar();

    void setStar(int star);

    Department getDpt();

    void setDpt(Department dpt);

    List<Task> getTasks();

    void setTasks(List<Task> tasks);

    int getFunds();

    void setFunds(int funds);
}
