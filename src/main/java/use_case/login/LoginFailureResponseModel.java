package use_case.login;

/**
 * the login failure response model
 */
public class LoginFailureResponseModel extends LoginResponseModel{

    /**
     * username
     */
    private final String username;

    /**
     * failure message
     */
    private final String message;

    /**
     * contruct LoginFailureResponseModel
     * @param username the username
     */
    public LoginFailureResponseModel(String username){
        this.username = username;
        this.message = "could not find user " + username;
    }

    /**
     * returns username
     */
    public String getUsername() {
        return username;
    }

    /**
     * returns failure message
     */
    public String getMessage(){
        return message;
    }
}
