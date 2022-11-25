package review_request;

import entity.Task;

public class ReviewRequestDsRequestModel {
    private Task task;

    public ReviewRequestDsRequestModel(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
