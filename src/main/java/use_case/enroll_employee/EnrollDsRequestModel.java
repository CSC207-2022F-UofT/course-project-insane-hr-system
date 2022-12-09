package use_case.enroll_employee;

import entity.user.User;

public class EnrollDsRequestModel {

    /**
     * Contains the new user that we want to save in the database.
     */
    private final User user;


    public EnrollDsRequestModel(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
