package controller;

import entity.CommonUser;
import rank_employees.RankInputBoundary;
import rank_employees.RankRequestModel;
import rank_employees.RankResponseModel;

import java.util.List;

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
