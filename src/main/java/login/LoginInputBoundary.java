package login;

import entity.User;

public interface LoginInputBoundary {

    public User getUser(LoginRequestModel logReqMod);

}
