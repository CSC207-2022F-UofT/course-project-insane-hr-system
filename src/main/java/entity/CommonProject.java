package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CommonProject extends CommonOrganization implements RealProject{
    private Department dpt;
    private List<Task> tasks = new ArrayList<>();
    private int funds;
    private int star;

    private final String projectType;

    public CommonProject(UUID oid, String name, Integer head, String description, LocalDateTime createTime, Department dpt, int funds) {
        super(oid, name, head, description, createTime);
        this.dpt = dpt;
        this.funds = funds;
        this.projectType = "COMMON";
    }

    public CommonProject(UUID oid, String name, int star, Integer head, Set<Integer> members, String description, LocalDateTime createTime, LocalDateTime closeTime,
                         Department dpt, List<Task> tasks, int funds) {
        super(oid, name, head, members, description, createTime, closeTime);
        this.dpt = dpt;
        this.tasks = tasks;
        this.funds = funds;
        this.star = star;
        this.projectType = "COMMON";
    }

    public CommonProject(UUID oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime,
                         Department dpt, List<Task> tasks, int funds) {
        super(oid, name, head, members, description, createTime);
        this.dpt = dpt;
        this.tasks = tasks;
        this.funds = funds;
        this.projectType = "COMMON";
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

    public String getType(){
        return this.projectType;
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
