package review_request;

import entity.Task;

public class ReviewRequestRequestModel {
    private Task task;
    private boolean approval;

    public ReviewRequestRequestModel(Task task, boolean approval) {
        this.task = task;
        this.approval = approval;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public boolean getApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }
}
