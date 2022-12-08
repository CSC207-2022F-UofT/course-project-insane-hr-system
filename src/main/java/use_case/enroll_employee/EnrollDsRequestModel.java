package use_case.enroll_employee;

import entity.user.User;

public class EnrollDsRequestModel {
    private final User user;

    public EnrollDsRequestModel(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
