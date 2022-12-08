package rank_employees;

import entity.CommonUser;

import java.util.List;

public class RankResponseModel {
    List<CommonUser> rankedEmployees;

    public RankResponseModel(List<CommonUser> rankedEmployees){
        this.rankedEmployees = rankedEmployees;
    }

    public List<CommonUser> getRankedEmployees(){
        return this.rankedEmployees;
    }

    public void setRankedEmployees(List<CommonUser> sortedSubordinates){
        this.rankedEmployees = sortedSubordinates;
    }

}
