package entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class AutoProject extends CommonOrganization implements Project  {
    private List<Task> tasks;

    public AutoProject(UUID oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime) {
        super(oid, name, head, members, description, createTime);
    }

    @Override
    public boolean addTask(Task task) {
        return this.tasks.add(task);
    }

    @Override
    public boolean removeTask(Task task) {
        return this.tasks.remove(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
