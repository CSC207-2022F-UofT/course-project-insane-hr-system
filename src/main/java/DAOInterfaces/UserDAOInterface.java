package DAOInterfaces;

import entity.*;

import java.util.List;

public interface UserDAOInterface {
    // get all users //
    List<User> getAllUsers();

    // get one user //
    User getUser(Integer uid);

    // create a user //
    void createUser(User user);

    // update a user //
    void updateUser(User user);

}
