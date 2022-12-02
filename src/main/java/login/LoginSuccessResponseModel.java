package login;

public class LoginSuccessResponseModel extends LoginResponseModel{

    private final int userID;

    public LoginSuccessResponseModel(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
}
