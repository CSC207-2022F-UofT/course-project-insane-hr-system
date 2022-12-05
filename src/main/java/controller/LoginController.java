package controller;

import login.LoginInputBoundary;
import login.LoginRequestModel;
import login.LoginResponseModel;

/**
 * the controller
 */
public class LoginController{

    /**
     * the interactor
     */
    LoginInputBoundary interactor = null;

    /**
     * constructs the controller
     * @param interactor login interactor
     */
    public LoginController(LoginInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * handles login boundaries
     * @param username username
     * @param password password
     * @return success model if user exists, failure model otherwise
     */
    public LoginResponseModel login(String username, String password) {
        LoginRequestModel logReqMod = new LoginRequestModel(username, password);
        return interactor.login(logReqMod);
    }

}
