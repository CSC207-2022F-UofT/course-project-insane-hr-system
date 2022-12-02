package presenter;

import login.LoginFailureResponseModel;
import login.LoginSuccessResponseModel;

// Use case layer

public interface LoginPresenter {

    LoginSuccessResponseModel prepareSuccessView(LoginSuccessResponseModel loginSuccessResponseModel);

    LoginFailureResponseModel prepareFailView(LoginFailureResponseModel logFailRepMod);

}