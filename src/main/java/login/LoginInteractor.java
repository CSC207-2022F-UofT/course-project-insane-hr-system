package login;

import entity.Curr;
import presenter.LoginPresenter;
import entity.User;


public class LoginInteractor implements LoginInputBoundary{

    final LoginDSGateway loginDsGateway;
    final LoginPresenter userPresenter;

    public LoginInteractor(LoginDSGateway loginDsGateway, LoginPresenter userPresenter){
        this.loginDsGateway = loginDsGateway;
        this.userPresenter = userPresenter;
    }

    public LoginResponseModel login(LoginRequestModel logReqMod) {
        if (loginDsGateway.userExists(logReqMod)){
            User user = loginDsGateway.getUser(logReqMod);
            this.setCurrentUser(user);
            int userID = user.getId();
            return new LoginSuccessResponseModel(userID);
        }
        else {
            LoginFailureResponseModel loginFailureResponseModel = new LoginFailureResponseModel(logReqMod.getUsername());
            userPresenter.prepareFailView(loginFailureResponseModel);
            return loginFailureResponseModel;
        }
    }

    public void setCurrentUser(User user){
        Curr.setUser(user);
    }
}
