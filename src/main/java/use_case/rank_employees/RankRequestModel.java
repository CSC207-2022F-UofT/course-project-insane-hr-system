package use_case.rank_employees;

import entity.Department;
import entity.user.CommonUser;

public class RankRequestModel {
    private int user;


    /*
    The RankRequestModel stores a current Users UID.
     */
    public RankRequestModel(int user){
        this.user = user;
    }

    /////// GETTERS AND SETTERS ////////
    public int getUserId(){
        return this.user;
    }

    public void setUserId(int user){this.user = user;}


}
