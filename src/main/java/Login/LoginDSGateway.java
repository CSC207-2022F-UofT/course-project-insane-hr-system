package Login;

public interface LoginDSGateway {

    void login(LoginRequestModel logReqMod);
    boolean userExists(LoginRequestModel logReqMod);

}
