package DAOInterfaces;

import entity.*;

import java.util.List;

public interface UserDAOInterface {


    // get all users //
    public List<CommonUser> getAllUsers();

    // get one user //
    public User getUser(int id);

    // create a user //
    public void createUser(CommonUser user);

    // update a user //
    public void updateUser(CommonUser user);

}
