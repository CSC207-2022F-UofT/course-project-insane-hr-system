package evaluate_task;

import entity.*;

public class EvaluateTaskResponseModel {

    private User employee;
    private String response;

    public EvaluateTaskResponseModel(User employee, String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }
}
