package use_case.enroll_employee;

import java.util.List;

public interface EnrollInputBoundary{
    EnrollResponseModel create(EnrollRequestModel requestModel);
    List<String> getAllDpts();
 
}
