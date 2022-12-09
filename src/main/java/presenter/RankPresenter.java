package presenter;

import use_case.rank_employees.RankOutputBoundary;
import use_case.rank_employees.RankResponseModel;

public class RankPresenter implements RankOutputBoundary {

    /*
    The RankPresenter displayRanking method takes a RankResponseModel and return the RankResponseModel. It
    is used to generate a view model.
     */
    public RankResponseModel displayRanking(RankResponseModel employeeRanking){
        return employeeRanking;
    }

}
