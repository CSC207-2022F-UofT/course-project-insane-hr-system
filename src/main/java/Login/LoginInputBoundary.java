package Login;

import Entity.User;

public interface LoginInputBoundary {

    public User getUser(LoginRequestModel logReqMod);

}
