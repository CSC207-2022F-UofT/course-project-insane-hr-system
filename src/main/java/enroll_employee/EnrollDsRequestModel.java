package enroll_employee;

import entity.User;

public class EnrollDsRequestModel {
    private User user;

    public EnrollDsRequestModel(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
