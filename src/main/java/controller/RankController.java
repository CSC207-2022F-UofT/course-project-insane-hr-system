//package controller;
//
//import entity.CommonUser;
//import RankEmployeesUseCase.RankInputBoundary;
//import RankEmployeesUseCase.RankRequestModel;
//import RankEmployeesUseCase.RankResponseModel;
//
//import java.util.List;
//
//public class RankController {
//    private final RankInputBoundary userInput;
//
//    public RankController(RankInputBoundary userInput){
//        this.userInput = userInput;
//    }
//
//    RankResponseModel create(List<CommonUser> subordinates){
//        RankRequestModel requestModel = new RankRequestModel(subordinates);
//        return userInput.create(requestModel);
//
//    }
//
//}
