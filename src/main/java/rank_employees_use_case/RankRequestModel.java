package rank_employees_use_case;

import entity.CommonUser;

import java.util.List;

public class RankRequestModel {
    private CommonUser currentUser;

    public RankRequestModel(CommonUser user){
        this.currentUser = user;
    }

    public CommonUser getCurrentUser(){
        return this.currentUser;
    }

    public void setCurrentUser(CommonUser user){this.currentUser = user;}


}
