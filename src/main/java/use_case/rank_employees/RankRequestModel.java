package use_case.rank_employees;

import entity.Department;
import entity.user.CommonUser;

public class RankRequestModel {
    private int user;

    public RankRequestModel(int user){
        this.user = user;
    }

    public int getUserId(){
        return this.user;
    }

    public void setUserId(int user){this.user = user;}


}
