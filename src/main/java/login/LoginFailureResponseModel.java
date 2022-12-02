package login;

public class LoginFailureResponseModel extends LoginResponseModel{

    private final String username;
    private final String message;

    public LoginFailureResponseModel(String username){
        this.username = username;
        this.message = "could not find user " + username;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage(){
        return message;
    }
}
