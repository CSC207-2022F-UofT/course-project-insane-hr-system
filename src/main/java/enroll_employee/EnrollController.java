package enroll_employee;

import entity.Department;
import entity.Position;


public class EnrollController {
    final EnrollInputBoundary enrollInput;

    public EnrollController(EnrollInputBoundary enrollInput) {
        this.enrollInput = enrollInput;
    }

    EnrollResponseModel create(String name, Department dpt, String position){
        EnrollRequestModel requestModel = new EnrollRequestModel(name,dpt,position);
        return enrollInput.create(requestModel);
    }
}
