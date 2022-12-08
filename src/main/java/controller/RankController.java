package controller;

import entity.CommonUser;
import entity.Department;
import rank_employees.RankInputBoundary;
import rank_employees.RankRequestModel;
import rank_employees.RankResponseModel;

import java.util.List;

public class RankController {
    private final RankInputBoundary userInput;

    public RankController(RankInputBoundary userInput){
        this.userInput = userInput;
    }

    RankResponseModel rankEmployees(Department dept){
        RankRequestModel requestModel = new RankRequestModel(dept);
        return userInput.rankEmployees(requestModel);

    }

}
