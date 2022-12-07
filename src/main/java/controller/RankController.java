package controller;

import entity.CommonUser;
import rank_employees_use_case.RankInputBoundary;
import rank_employees_use_case.RankRequestModel;
import rank_employees_use_case.RankResponseModel;

import java.util.List;

public class RankController {
    private final RankInputBoundary userInput;

    public RankController(RankInputBoundary userInput){
        this.userInput = userInput;
    }

    RankResponseModel create(RankRequestModel requestModel){
        return userInput.create(requestModel);

    }

}
