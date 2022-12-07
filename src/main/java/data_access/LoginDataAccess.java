package data_access;

import DAO.CommonUserDAO;
import entity.CommonUser;
import entity.User;
import login.LoginDSGateway;
import login.LoginRequestModel;

import java.util.List;

public class LoginDataAccess implements LoginDSGateway {
    @Override
    public User getUser(LoginRequestModel logReqMod) {
        CommonUserDAO commonUserDAO = new CommonUserDAO();
        List<CommonUser> userList = commonUserDAO.getAllCommonUsers();
        for (CommonUser user : userList) {
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
        CommonUserDAO commonUserDAO = new CommonUserDAO();
        List<CommonUser> userList = commonUserDAO.getAllCommonUsers();
        if (userList != null) {
            for (CommonUser user : userList) {
                if (user.getUsername().equals(logReqMod.getUsername())
                        && user.getPassword().equals(logReqMod.getPassword())) {
                    userExists = true;
                }
            }
        }
        return userExists;
    }
}
