package presenter;

import controller.CheckProfileController;
import login.LoginFailureResponseModel;
import login.LoginSuccessResponseModel;

public class LoginResponseFormatter implements LoginPresenter {
    @Override
    public LoginSuccessResponseModel prepareSuccessView(LoginSuccessResponseModel loginSuccessModel) {
        return loginSuccessModel;
    }

    @Override
    public LoginFailureResponseModel prepareFailView(LoginFailureResponseModel loginFailureModel) {
        return loginFailureModel;
    }
}
