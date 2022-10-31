package Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public abstract class Project extends AbstractOrganization{
    private Department dpt;
    private List<Task> tasks;
    private int funds;


    public Project(int oid, String name, int star, User head, List<Integer> members, String description, LocalDateTime creatTime, LocalDateTime closeTime,
                   Department dpt, List<Task> tasks, int funds) {
        super(oid, name, star, head, members, description, creatTime, closeTime);
        this.dpt = dpt;
        this.tasks = tasks;
        this.funds = funds;
    }

    public Project(int oid, String name, int star, User head, List<Integer> members, String description, LocalDateTime creatTime,
                   Department dpt, List<Task> tasks, int funds) {
        super(oid, name, star, head, members, description, creatTime);
        this.dpt = dpt;
        this.tasks = tasks;
        this.funds = funds;
    }

    // adding/removing task

    public boolean addTask(Task task) {
        return this.tasks.add(task);
    }
    public boolean removeTask(Task task) {
        return this.tasks.remove(task);
    }

    public Department getDpt() {
        return dpt;
    }

    public void setDpt(Department dpt) {
        this.dpt = dpt;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }
}
