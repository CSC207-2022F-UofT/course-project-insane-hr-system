package controller;

import login.LoginInputBoundary;
import login.LoginInteractor;
import login.LoginRequestModel;


public class LoginController{

    final LoginInputBoundary interactor;

    public LoginController(LoginInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void Login(String username, String password) {
        LoginRequestModel logReqMod = new LoginRequestModel(username, password);
        interactor.login(logReqMod);
    }

}
