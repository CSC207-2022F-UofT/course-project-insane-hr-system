package rank_employees;

import entity.CommonUser;
import entity.Department;

public class RankRequestModel {
    private Department currentDepartment;

    public RankRequestModel(Department dept){
        this.currentDepartment = dept;
    }

    public Department getCurrentDepartment(){
        return this.currentDepartment;
    }

    public void setCurrentDepartment(Department dept){this.currentDepartment = dept;}


}
