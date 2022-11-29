package view_model;

import presenter.UserIViewModel;

public class UserDataModel extends UIDataModel implements UserIViewModel {
    private Integer uid;

    public UserDataModel(Integer uid, String frameName, String infoTitle, String intro, Table leftTable, Table rightTable ) {
        super(frameName, infoTitle, intro, leftTable, rightTable);
        this.uid = uid;
    }

    public UserDataModel(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    @Override
    public void setUid(Integer uid) {

    }

}
