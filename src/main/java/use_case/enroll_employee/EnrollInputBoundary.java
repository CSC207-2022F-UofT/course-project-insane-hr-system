package use_case.enroll_employee;

import java.util.List;

public interface EnrollInputBoundary{

    /**
     * Based on the user input information to create a new user.
     * @param requestModel contains all the user input information
     * @return a reponse model that contains the generated user id, username and user password.
     */
    EnrollResponseModel create(EnrollRequestModel requestModel);


    /**
     * Get all the department names in our database
     * @return a list string that contains the name of all the departments in our database.
     */
    List<String> getAllDpts();
 
}
