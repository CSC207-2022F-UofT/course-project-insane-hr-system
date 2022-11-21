package login;

public class LoginResponseModel {

    private final String message;

    public LoginResponseModel(Boolean loginSuccessful) {
        if (loginSuccessful) {
            this.message = "login successful";
        }
        else {
            this.message = "login failed: user does not exist";
        }
    }

    private String getMessage(){ return this.message; }

}
