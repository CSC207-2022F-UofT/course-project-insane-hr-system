package use_case.rank_employees;

import entity.user.CommonUser;

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
