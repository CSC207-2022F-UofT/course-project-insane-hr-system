package use_case.complete_task;

import entity.task.Task;
import entity.user.User;

public class CompleteTaskRequestModel {
    private final UUID taskId;
    private User user;

    public CompleteTaskRequestModel(UUID taskId, User user) {
        this.taskId = taskId;
        this.user = user;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
