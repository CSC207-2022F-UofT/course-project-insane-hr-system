package use_case.rank_employees;

public interface RankInputBoundary {
    /*
    The RankInputBoundary takes a request model and create a RankResponseModel from it.
     */
    RankResponseModel create(RankRequestModel requestModel);
}
