package RankEmployeesUseCase;

import entity.CommonUser;

import java.util.List;

public class RankRequestModel {
    private final List<CommonUser> subordinateList;

    public RankRequestModel(List<CommonUser> subordinateList){
        this.subordinateList = subordinateList;
    }

    public List<CommonUser> getSubordinates(){
        return subordinateList;
    }


}
