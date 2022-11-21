package presenter;

import entity.User;
import login.LoginResponseModel;

// Use case layer

public interface LoginPresenter {

    void prepareSuccessView(User user, LoginResponseModel loginResponseModel);

    void prepareFailView(LoginResponseModel logFailRepMod);

}