package use_case.rank_employees;

import entity.user.CommonUser;

import java.util.List;

public class RankResponseModel {
    private List<String> rankedEmployees;

    /*
    The RankResponseModel contains a List of Strings that are user's names that are sorted by a user's
    average task rating.
     */
    public RankResponseModel(List<String> rankedEmployees) {
        this.rankedEmployees = rankedEmployees;
    }

    ///// GETTERS AND SETTERS /////
    public List<String> getRankedEmployees() {
        return this.rankedEmployees;
    }

}
