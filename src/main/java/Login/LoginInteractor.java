package Login;

import Entity.User;
import Presenter.LoginResponsePresenter;


public class LoginInteractor {

    final LoginDSGateway loginDsGateway;
    final LoginResponsePresenter userPresenter;

    public static void login(LoginRequestModel logReqMod){
        // if not gateway.userExists(logreqMod){
        // LoginFailureResponseModel(
    }

    public LoginInteractor(LoginDSGateway loginDsGateway, LoginResponsePresenter userPresenter){
        this.loginDsGateway = loginDsGateway;
        this.userPresenter = userPresenter;
    }

    public static User getUser(LoginRequestModel logReqMod) {
        // User user = gateway.getUser(LoginRequestModel)
        // LoginResponsePresenter.displayUser(User)
    }
}
