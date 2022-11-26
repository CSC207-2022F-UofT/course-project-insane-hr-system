package controller;

import login.LoginInputBoundary;
import login.LoginRequestModel;


public class LoginController{

    LoginInputBoundary interactor = null;

    public LoginController(LoginInputBoundary interactor) {
        this.interactor = interactor;
    }

    public LoginController(){}

    public void login(String username, String password) {
        LoginRequestModel logReqMod = new LoginRequestModel(username, password);
        interactor.login(logReqMod);
    }

}
