package presenter;

import entity.User;
import login.LoginResponseModel;

public class LoginResponseFormatter implements LoginPresenter {
    @Override
    public LoginResponseModel prepareSuccessView(User user, LoginResponseModel loginSuccessModel) {
        return loginSuccessModel;
    }

    @Override
    public LoginResponseModel prepareFailView(LoginResponseModel loginFailureModel) {
        return loginFailureModel;
    }
}
