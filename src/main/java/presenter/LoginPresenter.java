package presenter;

import login.LoginFailureResponseModel;
import login.LoginSuccessResponseModel;

/**
 * the login presenter
 */
public interface LoginPresenter {

    /**
     * returns the successful response model
     * @param loginSuccessResponseModel the successful response model
     * @return the successful response model
     */
    LoginSuccessResponseModel prepareSuccessView(LoginSuccessResponseModel loginSuccessResponseModel);

    /**
     * returns the failure response model
     * @param loginFailureResponseModel the failure response model
     * @return the failure response model
     */
    LoginFailureResponseModel prepareFailView(LoginFailureResponseModel loginFailureResponseModel);

}