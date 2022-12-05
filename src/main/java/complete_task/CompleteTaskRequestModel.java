package complete_task;

import entity.*;



public class CompleteTaskRequestModel {
    private Task task;
    private User user;

    public CompleteTaskRequestModel(Task task, User user) {
        this.task = task;
        this.user = user;
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

}
