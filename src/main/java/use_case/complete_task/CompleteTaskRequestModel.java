package use_case.complete_task;

import entity.Task;
import entity.User;

public class CompleteTaskRequestModel {
    private Task task;
    private User user;
    private String message;

    public CompleteTaskRequestModel(Task task, User user, String message) {
        this.task = task;
        this.user = user;
        this.message = message;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
