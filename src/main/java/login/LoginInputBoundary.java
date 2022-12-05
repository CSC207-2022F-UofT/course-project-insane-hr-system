package login;

/**
 * the login input boundary
 */
public interface LoginInputBoundary {

    /**
     * login the user
     * @param logReqMod username and password
     * @return returns success model if user exists, failure model otherwise
     */
    public LoginResponseModel login(LoginRequestModel logReqMod);

}
