package controller;

import entity.user.CommonUser;
import use_case.rank_employees.RankInputBoundary;
import use_case.rank_employees.RankRequestModel;
import use_case.rank_employees.RankResponseModel;

public class RankController {
    private final RankInputBoundary userInput;

    public RankController(RankInputBoundary userInput){
        this.userInput = userInput;
    }

    RankResponseModel create(CommonUser user){
        RankRequestModel requestModel = new RankRequestModel(user);
        return userInput.create(requestModel);

    }

}
