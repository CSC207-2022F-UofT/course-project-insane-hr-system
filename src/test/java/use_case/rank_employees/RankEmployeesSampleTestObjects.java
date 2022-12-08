package use_case.rank_employees;

import entity.CommonUser;
import entity.Department;
import rank_employees.RankRequestModel;
import rank_employees.RankResponseModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


public class RankEmployeesSampleTestObjects {

    public RankRequestModel emptyDepartment(){
        // if there is only 1 member in the department they are the head.

        UUID id = UUID.randomUUID();
        LocalDateTime createTime =  LocalDateTime.of(2002,3,16,9,5);

        Department department = new Department(id, "SECURITY", "A department focused on product security.", createTime);
        CommonUser user = new CommonUser(12, department, "My name is Dan and I'm the head of our new security team.", "Dan Mich");
        RankRequestModel requestModel = new RankRequestModel(department);

        return requestModel;
    }





}
