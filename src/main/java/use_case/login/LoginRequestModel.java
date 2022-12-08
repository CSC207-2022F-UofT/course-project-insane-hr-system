package use_case.login;

/**
 * the login request model
 */
public class LoginRequestModel {

    /**
     * username
     */
    private final String username;

    /**
     * password
     */
    private final String password;

    /**
     * construct the login request model
     * @param username username
     * @param password password
     */
    public LoginRequestModel(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * gets the username
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * gets the password
     */
    public String getPassword(){
        return this.password;
    }

}
