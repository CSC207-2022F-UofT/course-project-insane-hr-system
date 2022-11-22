package controller;


import enroll_employee.EnrollInputBoundary;
import enroll_employee.EnrollRequestModel;
import enroll_employee.EnrollResponseModel;

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
