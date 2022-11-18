package Login;

public class LoginRequestModel {

    private final String username;
    private final String password;

    public LoginRequestModel(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }
}
