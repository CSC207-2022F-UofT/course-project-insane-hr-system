package Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class AutoProject extends CommonOrganization {
    private List<Task> tasks;

    public AutoProject(int oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime creatTime) {
        super(oid, name, head, members, description, creatTime);
    }


    public boolean addTask(CommonTask commonTask) {
        return this.tasks.add(commonTask);
    }

    public boolean removeTask(CommonTask commonTask) {
        return this.tasks.remove(commonTask);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> commonTasks) {
        this.tasks = commonTasks;
    }

}
