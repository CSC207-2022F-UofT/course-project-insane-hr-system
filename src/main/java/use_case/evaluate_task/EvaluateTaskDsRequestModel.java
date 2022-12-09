package use_case.evaluate_task;

import entity.task.Task;

public class EvaluateTaskDsRequestModel {
    private Task task;

    public EvaluateTaskDsRequestModel(Task task) {
        this.task =task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
