package controller;

import entity.Department;
import entity.user.CommonUser;
import use_case.rank_employees.RankInputBoundary;
import use_case.rank_employees.RankRequestModel;
import use_case.rank_employees.RankResponseModel;

public class RankController {
    private final RankInputBoundary userInput;

    public RankController(RankInputBoundary userInput){
        this.userInput = userInput;
    }

    public RankResponseModel create(int id){
        RankRequestModel requestModel = new RankRequestModel(id);
        return userInput.create(requestModel);

    }

}
