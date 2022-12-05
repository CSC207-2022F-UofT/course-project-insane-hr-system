package login;

/**
 * login successful response model
 */
public class LoginSuccessResponseModel extends LoginResponseModel{

    /**
     * the userID
     */
    private final int userID;

    /**
     * constructs the successful response model
     * @param userID the user ID
     */
    public LoginSuccessResponseModel(int userID) {
        this.userID = userID;
    }

    /**
     * gets the userID
     */
    public int getUserID() {
        return userID;
    }
}
