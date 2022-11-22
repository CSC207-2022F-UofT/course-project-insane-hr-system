package enroll_employee;


import java.util.List;


public class EnrollController {
    final EnrollInputBoundary enrollInput;

    public EnrollController(EnrollInputBoundary enrollInput) {
        this.enrollInput = enrollInput;
    }

    EnrollResponseModel create(String name, String dpt, String position){
        EnrollRequestModel requestModel = new EnrollRequestModel(name,dpt,position);
        return enrollInput.create(requestModel);
    }

    List<String> getDpts(){
        return enrollInput.getAllDpts();
    }
}
