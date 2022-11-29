package view_model;

public class UserDataModel extends UIDataModel{
    private final Integer uid;
    private final UserType userType;

    public UserDataModel(Integer uid, UserType userType, String frameName, String infoTitle, String intro, Table leftTable, Table rightTable) {
        super(uid, frameName, infoTitle, intro, leftTable, rightTable);
        this.uid = uid;
        this.userType = userType;
    }

    public Integer getUid() {
        return uid;
    }

    public UserType getUserType() {
        return userType;
    }
}
