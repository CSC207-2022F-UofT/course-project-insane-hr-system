package enroll_employee;

import entity.Department;

import java.util.List;

public interface EnrollInputBoundary{
    EnrollResponseModel create(EnrollRequestModel requestModel);
    List<String> getAllDpts();
 
}
