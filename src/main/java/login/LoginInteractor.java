package login;

import entity.Curr;
import presenter.LoginPresenter;
import entity.User;


public class LoginInteractor<LoginReponseModel> implements LoginInputBoundary{

    final LoginDSGateway loginDsGateway;
    final LoginPresenter userPresenter;
    final Curr currentUser;

    public LoginInteractor(LoginDSGateway loginDsGateway, LoginPresenter userPresenter, Curr currentUser){
        this.loginDsGateway = loginDsGateway;
        this.userPresenter = userPresenter;
        this.currentUser = currentUser;
    }

    public void login(LoginRequestModel logReqMod) {
        if (loginDsGateway.userExists(logReqMod)){
            User user = loginDsGateway.getUser(logReqMod);
            LoginResponseModel loginResponseModel = new LoginResponseModel(true);
            userPresenter.prepareSuccessView(user, loginResponseModel);
        }
        else {
            LoginResponseModel loginResponseModel = new LoginResponseModel(false);
            userPresenter.prepareFailView(loginResponseModel);
        }
    }

    public void setCurrUser(Curr currentUser, User user){

    }
}
