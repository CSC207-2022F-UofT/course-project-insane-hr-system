package delete_employee;

import entity.User;

public class DeleteRequestModel {
    private User user;

    public DeleteRequestModel(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
