package controller;


import use_case.enroll_employee.EnrollInputBoundary;
import use_case.enroll_employee.EnrollRequestModel;
import use_case.enroll_employee.EnrollResponseModel;

import java.util.List;


public class EnrollController {
    public final EnrollInputBoundary enrollInput;

    public EnrollController(EnrollInputBoundary enrollInput) {
        this.enrollInput = enrollInput;
    }

    public EnrollResponseModel create(String name, String dpt, String position){
        EnrollRequestModel requestModel = new EnrollRequestModel(name,dpt,position);
        return enrollInput.create(requestModel);
    }

    List<String> getDpts(){
        return enrollInput.getAllDpts();
    }
}
