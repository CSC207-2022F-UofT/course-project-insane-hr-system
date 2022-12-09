package use_case.enroll_employee;

public interface EnrollOutputBoundary {

    /**
     *  Prepare Success view when we finish enroll a new employee.
     * @param user is the new employee that we added into our database.
     * @return a reponse mondel that contains all the information that we want to show in the UI.
     */
    EnrollResponseModel prepareSuccessView (EnrollResponseModel user);


    /**
     * Prepare failure view when CEO doesn't input the name of the new employee.
     * @param error is the error message that will be shown in the UI
     * @return a resonse model that contains the error message.
     */
    EnrollResponseModel prepareFailView (String error);
}
