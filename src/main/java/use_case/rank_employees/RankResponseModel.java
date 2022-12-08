package use_case.rank_employees;

import entity.user.CommonUser;

import java.util.List;

public class RankResponseModel {
    List<String> rankedEmployees;

    public RankResponseModel(List<String> rankedEmployees){
        this.rankedEmployees = rankedEmployees;
    }

    public List<String> getRankedEmployees(){
        return this.rankedEmployees;
    }

    public void setRankedEmployees(List<String> sortedSubordinates){
        this.rankedEmployees = sortedSubordinates;
    }

}
