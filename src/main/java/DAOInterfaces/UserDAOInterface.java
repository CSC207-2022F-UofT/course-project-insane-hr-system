package DAOInterfaces;

import entity.*;

import java.util.List;
import java.util.UUID;

public interface UserDAOInterface {
    // get all users //
    public List<User> getAllUsers();

    // get one user //
    public User getUser(int id);

    // create a user //
    public void createUser(User user);

    // update a user //
    public void updateUser(User user);

}
