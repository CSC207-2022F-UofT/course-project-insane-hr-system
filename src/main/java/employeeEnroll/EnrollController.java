package employeeEnroll;

import entity.Department;

public class EnrollController {
    final EnrollInputBoundary enrollInput;

    public EnrollController(EnrollInputBoundary enrollInput) {
        this.enrollInput = enrollInput;
    }

    EnrollResponseModel create(String name, Department dpt){
        EnrollRequestModel requestModel = new EnrollRequestModel(name,dpt);
        return enrollInput.create(requestModel);
    }
}
