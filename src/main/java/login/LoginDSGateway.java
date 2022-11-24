package login;

import entity.User;

public interface LoginDSGateway {

    User getUser(LoginRequestModel logReqMod);
    boolean userExists(LoginRequestModel logReqMod);

}
