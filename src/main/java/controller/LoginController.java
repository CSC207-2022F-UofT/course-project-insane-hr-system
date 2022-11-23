package controller;

import login.LoginInteractor;
import login.LoginRequestModel;

public class LoginController{

    public static void Login(String username, String password) {
        LoginRequestModel logReqMod = new LoginRequestModel(username, password);
        LoginInteractor.getUser(logReqMod);
    }
}
