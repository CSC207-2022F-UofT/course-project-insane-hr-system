package presenter;

import controller.CheckProfileController;
import login.LoginFailureResponseModel;
import login.LoginSuccessResponseModel;

/**
 * the response formatter
 */
public class LoginResponseFormatter implements LoginPresenter {

    /**
     * returns the successful response model
     * @param loginSuccessResponseModel the successful response model
     * @return the successful response model
     */
    @Override
    public LoginSuccessResponseModel prepareSuccessView(LoginSuccessResponseModel loginSuccessResponseModel) {
        return loginSuccessResponseModel;
    }

    /**
     * returns the failure response model
     * @param loginFailureResponseModel the failure response model
     * @return the failure response model
     */
    @Override
    public LoginFailureResponseModel prepareFailView(LoginFailureResponseModel loginFailureResponseModel) {
        return loginFailureResponseModel;
    }
}
