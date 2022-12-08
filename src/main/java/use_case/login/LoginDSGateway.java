package use_case.login;

import entity.User;

/**
 * the gateway
 */
public interface LoginDSGateway {

    /**
     * gets user
     * @param logReqMod username and password
     * @return returns user object
     */
    User getUser(LoginRequestModel logReqMod);
    /**
     * checks whether user exists
     * @param logReqMod username and password
     * @return true if user exists, false otherwise
     */
    boolean userExists(LoginRequestModel logReqMod);

}
