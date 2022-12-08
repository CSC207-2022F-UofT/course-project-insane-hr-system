package presenter;

import use_case.enroll_employee.EnrollOutputBoundary;
import use_case.enroll_employee.EnrollResponseModel;
import use_case.enroll_employee.UserCreationFailed;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EnrollPresenter implements EnrollOutputBoundary {
    @Override
    public EnrollResponseModel prepareSuccessView(EnrollResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.now();
        responseModel.setCreationTime(LocalDate.from(responseTime));
        return responseModel;
    }

    @Override
    public EnrollResponseModel prepareFailView(String error){
        throw new UserCreationFailed(error);
    }
}
