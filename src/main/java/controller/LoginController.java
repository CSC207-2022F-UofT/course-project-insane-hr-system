package controller;

import login.LoginInputBoundary;
import login.LoginRequestModel;
import login.LoginResponseModel;


public class LoginController{

    LoginInputBoundary interactor = null;

    public LoginController(LoginInputBoundary interactor) {
        this.interactor = interactor;
    }

    public LoginController(){}

    public LoginResponseModel login(String username, String password) {
        LoginRequestModel logReqMod = new LoginRequestModel(username, password);
        return interactor.login(logReqMod);
    }

}
