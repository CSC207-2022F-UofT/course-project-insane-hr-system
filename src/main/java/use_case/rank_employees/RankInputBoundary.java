package use_case.rank_employees;

public interface RankInputBoundary {
    RankResponseModel create(RankRequestModel requestModel);
}
