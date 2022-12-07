package my_dao;

import DAOInterfaces.UserDAOInterface;
import entity.CommonUser;
import entity.User;

import java.util.List;

public class userDao implements UserDAOInterface {
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUser(Integer uid) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }
}
