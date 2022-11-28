package evaluate_task;
import entity.*;

public class EvaluateTaskRequestModel {
    private Task task;
    private User user;
    private int star;
    private String message;

    public EvaluateTaskRequestModel(Task task, User user, int star, String message) {
        this.task = task;
        this.user = user;
        this.star = star;
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
