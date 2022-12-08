package use_case.evaluate_task;

import entity.Task;

public class EvaluateTaskResponseModel {
    private String response;

    public EvaluateTaskResponseModel(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
