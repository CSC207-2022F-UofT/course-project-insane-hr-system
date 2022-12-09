package use_case.login;

import controller.LoginController;
import data_access.LoginDataAccess;
import entity.Curr;
import entity.user.CommonUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presenter.LoginPresenter;
import presenter.LoginResponseFormatter;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * login interactor tests
 */
public class LoginInteractorTest {

    @BeforeEach
    void setUp() {
        Curr.setUser(new CommonUser(10));
    }

    @AfterEach
    void tearDown() {
    }

    /*
     * test unsuccessful login
     */
    @Test
    void unsuccessfulLogin() {
        LoginPresenter loginPresenter = new LoginResponseFormatter();
        LoginDataAccess loginDataAccess = new LoginDataAccess();
        LoginInputBoundary interactor = new LoginInteractor(loginDataAccess, loginPresenter);
        LoginController loginController = new LoginController(interactor);
        LoginRequestModel loginRequestModel = new LoginRequestModel("badUser", "12345");
        LoginResponseModel loginResponseModel = interactor.login(loginRequestModel);
        assert (loginResponseModel instanceof LoginFailureResponseModel);
    }

    /*
     * test successful login
     */
    @Test
    void successfulLogin() {
        LoginPresenter loginPresenter = new LoginResponseFormatter();
        LoginDataAccess loginDataAccess = new LoginDataAccess();
        LoginInputBoundary interactor = new LoginInteractor(loginDataAccess, loginPresenter);
        LoginController loginController = new LoginController(interactor);
        LoginRequestModel loginRequestModel = new LoginRequestModel("test", "test");
        LoginResponseModel loginResponseModel = interactor.login(loginRequestModel);
        assert (loginResponseModel instanceof LoginSuccessResponseModel);
    }
}
