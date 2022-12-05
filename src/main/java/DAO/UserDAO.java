package DAO;

import DAOInterfaces.UserDAOInterface;
import entity.CommonUser;
import entity.Task;

import java.util.List;

public class UserDAO implements UserDAOInterface {
    @Override
    public List<CommonUser> getAllUsers() {
        return null;
    }

    @Override
    public Task getUser(int id) {
        return null;
    }

    @Override
    public void createUser(CommonUser user) {

    }

    @Override
    public void updateUser(CommonUser user) {

    }
}
