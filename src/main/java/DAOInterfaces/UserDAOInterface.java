package DAOInterfaces;

import entity.*;

import java.util.List;
import java.util.UUID;

public interface UserDAOInterface {


    // get all users //
    public List<CommonUser> getAllUsers();

    // get one user //
    public Task getUser(int id);

    // create a user //
    public void createUser(CommonUser user);

    // update a user //
    public void updateUser(CommonUser user);

}
