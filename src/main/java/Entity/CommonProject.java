package Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class CommonProject extends CommonOrganization implements RealProject{
    private Department dpt;
    private List<Task> tasks;
    private int funds;
    private int star;


    public CommonProject(int oid, String name, int star, Integer head, Set<Integer> members, String description, LocalDateTime creatTime, LocalDateTime closeTime,
                         Department dpt, List<Task> tasks, int funds) {
        super(oid, name, head, members, description, creatTime, closeTime);
        this.dpt = dpt;
        this.tasks = tasks;
        this.funds = funds;
        this.star = star;
    }

    public CommonProject(int oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime creatTime,
                         Department dpt, List<Task> tasks, int funds) {
        super(oid, name, head, members, description, creatTime);
        this.dpt = dpt;
        this.tasks = tasks;
        this.funds = funds;
    }

    // adding/removing task

    @Override
    public boolean addTask(Task Task) {
        return this.tasks.add(Task);
    }
    @Override
    public boolean removeTask(Task Task) {
        return this.tasks.remove(Task);
    }

    @Override
    public int getStar() {
        return star;
    }

    @Override
    public void setStar(int star) {
        this.star = star;
    }

    @Override
    public Department getDpt() {
        return dpt;
    }

    @Override
    public void setDpt(Department dpt) {
        this.dpt = dpt;
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int getFunds() {
        return funds;
    }

    @Override
    public void setFunds(int funds) {
        this.funds = funds;
    }
}
