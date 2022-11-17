package Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class AutoProject extends CommonOrganization implements Project  {
    private List<Task> tasks;

    public AutoProject(int oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime creatTime) {
        super(oid, name, head, members, description, creatTime);
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

    public void setTasks(List<Task> commonTasks) {
        this.tasks = commonTasks;
    }

}
