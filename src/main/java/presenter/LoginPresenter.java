package presenter;

import entity.User;
import login.LoginResponseModel;

// Use case layer

public interface LoginPresenter {

    LoginResponseModel prepareSuccessView(User user, LoginResponseModel loginResponseModel);

    LoginResponseModel prepareFailView(LoginResponseModel logFailRepMod);

}