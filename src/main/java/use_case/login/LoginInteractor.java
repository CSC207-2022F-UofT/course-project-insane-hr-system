package use_case.login;

import entity.Curr;
import presenter.LoginPresenter;
import entity.user.User;

/**
 * the interactor
 */
public class LoginInteractor implements LoginInputBoundary{

    /**
     * the gateway to access the user from database
     */
    final LoginDSGateway loginDsGateway;

    /**
     * the presenter
     */
    final LoginPresenter userPresenter;

    /**
     * interactor constructor
     * @param loginDsGateway gateway
     * @param userPresenter presenter
     */
    public LoginInteractor(LoginDSGateway loginDsGateway, LoginPresenter userPresenter){
        this.loginDsGateway = loginDsGateway;
        this.userPresenter = userPresenter;
    }

    /**
     * assigns current user to Curr and returns userID if user exists
     * returns failure message otherwise
     * @param logReqMod username, password
     * @return success-model if successful, failure-model otherwise
     */
    public LoginResponseModel login(LoginRequestModel logReqMod) {
        if (loginDsGateway.userExists(logReqMod)){
            User user = loginDsGateway.getUser(logReqMod);
            this.setCurrentUser(user);
            int userID = user.getId();
            return new LoginSuccessResponseModel(userID);
        }
        else {
            return new LoginFailureResponseModel(logReqMod.getUsername());
        }
    }

    /**
     * sets current user of Curr
     */
    public void setCurrentUser(User user){
        Curr.setUser(user);
    }
}
