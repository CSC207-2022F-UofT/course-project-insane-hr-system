package entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static entity.Constants.CLOSED;

public class LeaveRequestProject extends CommonOrganization implements Project {
    private List<Task> tasks;
    private int numResponses = 0;

    public LeaveRequestProject(UUID oid, String name, Integer head, Set<Integer> members, String description,
                               LocalDateTime createTime) {
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

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getNumResponses() {
        return numResponses;
    }

    public void setNumResponses(int numResponses) {
        this.numResponses = numResponses;
    }

    @Override
    public void close() {
        this.setState(CLOSED);
        this.setCloseTime(LocalDateTime.now());
        // TODO: get userFile from head/uid, update user status
    }

    public void update() {
        this.numResponses += 1;
        // close the project when all responses have been gathered
        if (this.numResponses == this.getMembers().size()) {
            this.close();
        }
    }
}
