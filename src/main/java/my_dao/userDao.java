package my_dao;

import DAOInterfaces.UserDAOInterface;
import entity.CommonUser;
import entity.User;

import java.util.List;

public class userDao implements UserDAOInterface {
    @Override
    public List<CommonUser> getAllTasks() {
        return null;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void createUser(CommonUser user) {

    }

    @Override
    public void updateUser(CommonUser user) {

    }
}
