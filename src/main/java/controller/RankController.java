package controller;

import entity.Department;
import entity.user.CommonUser;
import use_case.rank_employees.RankInputBoundary;
import use_case.rank_employees.RankRequestModel;
import use_case.rank_employees.RankResponseModel;

public class RankController {
    private final RankInputBoundary userInput;

    /*
    The RankController stores a reference to the RankInputBoundary.
     */
    public RankController(RankInputBoundary userInput){
        this.userInput = userInput;
    }

    /*
    The RankController creates a RankRequestModel by taking user input,
    converting it to a RankRequestModel and sending it to a RankInputBoundary.
     */
    public RankResponseModel create(int id){
        RankRequestModel requestModel = new RankRequestModel(id);
        return userInput.create(requestModel);

    }

}
