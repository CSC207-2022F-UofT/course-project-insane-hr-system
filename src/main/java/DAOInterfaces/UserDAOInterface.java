package DAOInterfaces;

import entity.CommonUser;
import entity.User;

import java.util.List;

public interface UserDAOInterface {

    // create a CommonUser
    public void createUser(User user);

    // update a CommonUser
    public void updateUser(User user);

    // get all CommonUsers
    public List<User> getAllUsers();

    // get one CommonUser
    public User getUser(int id);
}
