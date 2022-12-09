package presenter;

import use_case.enroll_employee.EnrollOutputBoundary;
import use_case.enroll_employee.EnrollResponseModel;
import use_case.enroll_employee.UserCreationFailed;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EnrollPresenter implements EnrollOutputBoundary {


    /**
     *
     * @param responseModel is the new employee that we added into our database.
     * @return reponse mondel that contains all the information that we want to show in the UI.
     */
    @Override
    public EnrollResponseModel prepareSuccessView(EnrollResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.now();
        responseModel.setCreationTime(LocalDate.from(responseTime));
        return responseModel;
    }


    /**
     * Prepare failure view when CEO doesn't input the name of the new employee.
     * @param error is the error message that will be shown in the UI
     * @return a resonse model that contains the error message.
     */
    @Override
    public EnrollResponseModel prepareFailView(String error){
        throw new UserCreationFailed(error);
    }
}
