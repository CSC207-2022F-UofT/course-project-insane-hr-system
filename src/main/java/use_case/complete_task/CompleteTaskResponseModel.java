package use_case.complete_task;

import entity.task.Task;

import java.util.UUID;

public class CompleteTaskResponseModel {
    private String response;

    public CompleteTaskResponseModel(String response) {
        this.response = response;
    }


    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
