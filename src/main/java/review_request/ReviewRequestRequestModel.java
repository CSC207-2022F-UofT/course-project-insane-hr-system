package review_request;

import entity.Task;

public class ReviewRequestRequestModel {
    private Task task;
    private boolean result;

    public ReviewRequestRequestModel(Task task, boolean result) {
        this.task = task;
        this.result = result;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
