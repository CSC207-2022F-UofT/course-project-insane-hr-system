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


    /**
     * Use the method in enroll input boundary.
     * @param name is the name that we get from user input.
     * @param dpt is the department that user select.
     * @param position is the employee position that user select.
     * @return a response model that contains the information that we want to show up when the system
     * finish its operation.
     */
    public EnrollResponseModel create(String name, String dpt, String position){
        EnrollRequestModel requestModel = new EnrollRequestModel(name,dpt,position);
        return enrollInput.create(requestModel);
    }

    /**
     * Get a list contains all the name of the current departments.
     * @return the name of the department
     */
    List<String> getDpts(){
        return enrollInput.getAllDpts();
    }
}
