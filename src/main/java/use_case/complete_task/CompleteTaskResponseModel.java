package use_case.complete_task;

import entity.task.Task;

public class CompleteTaskResponseModel {
    private Task task;
    private String response;

    public CompleteTaskResponseModel(Task task, String response) {
        this.task = task;
        this.response = response;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
