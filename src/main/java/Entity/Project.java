package Entity;

import java.util.List;
import java.util.Objects;

public abstract class Project extends AbstractOrganization{
    private Department dpt;
    private List<Task> tasks;
    private int funds;

    public Project(String name,
                   int star,
                   User head,
                   List<User> members,
                   String creatTime,
                   String closeTime,
                   String description,
                   Department dpt,
                   List<Task> tasks,
                   int funds) {
        super(name, star, head, members, creatTime, closeTime, description);
        this.dpt = dpt;
        this.tasks = tasks;
        this.funds = funds;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public boolean removeTask(String taskName) {
        for (Task task : this.tasks) {
            if (taskName.equals(task.name)) {
                this.tasks.remove(task);
                return true;
            }
        }
        return false;
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
