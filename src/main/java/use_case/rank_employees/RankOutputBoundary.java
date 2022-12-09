package use_case.rank_employees;

// The RankOutputBoundary is implemented by the RankPresenter.
public interface RankOutputBoundary {
    /*
    The RankOutputBoundary displayRanking method takes a RankResponseModel and return a RankResponseModel to be used
    to displayRanking.
     */
    RankResponseModel displayRanking(RankResponseModel employeeRanking);
}
