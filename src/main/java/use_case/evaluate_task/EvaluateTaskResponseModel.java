package use_case.evaluate_task;

import entity.*;
import entity.user.User;

public class EvaluateTaskResponseModel {

    private Integer star;
    private User employee;
    private String response;

    public EvaluateTaskResponseModel(int star, User employee, String response) {
        this.star = star;
        this.employee = employee;
        this.response = response;
    }
    public int getStar() {
        return star;
    }
    public void setStar(Integer star) {
        this.star = star;
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
