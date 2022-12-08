package data_access;

import DAO.UserDAO;
import entity.User;
import use_case.login.LoginDSGateway;
import use_case.login.LoginRequestModel;

import java.util.List;

public class LoginDataAccess implements LoginDSGateway {
    @Override
    public User getUser(LoginRequestModel logReqMod) {
        UserDAO userDAO = new UserDAO();
        List<User> userList = userDAO.getAllUsers();
        for (User user : userList) {
            if (user.getUsername().equals(logReqMod.getUsername())
                    && user.getPassword().equals(logReqMod.getPassword())){
                    return user;
            }
        }
        throw new RuntimeException("Error: user not found");
    }


    @Override
    public boolean userExists(LoginRequestModel logReqMod) {
        boolean userExists = false;
        UserDAO userDAO = new UserDAO();
        List<User> userList = userDAO.getAllUsers();
        if (userList != null) {
            for (User user : userList) {
                if (user.getUsername().equals(logReqMod.getUsername())
                        && user.getPassword().equals(logReqMod.getPassword())) {
                    userExists = true;
                }
            }
        }
        return userExists;
    }
}
