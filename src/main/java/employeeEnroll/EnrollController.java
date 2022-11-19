package employeeEnroll;

public class EnrollController {
    final EnrollInputBoundary enrollInput;

    public EnrollController(EnrollInputBoundary enrollInput) {
        this.enrollInput = enrollInput;
    }

    EnrollResponseModel create(String name){
        EnrollRequestModel requestModel = new EnrollRequestModel(name);
        return enrollInput.create(requestModel);
    }
}
