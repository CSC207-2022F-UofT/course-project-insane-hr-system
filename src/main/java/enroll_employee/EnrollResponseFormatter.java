package enroll_employee;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EnrollResponseFormatter implements EnrollPresenter{
    @Override
    public EnrollResponseModel prepareSuccessView(EnrollResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.now();
        responseModel.setCreationTime(LocalDate.from(responseTime));
        return responseModel;
    }

    @Override
    public EnrollResponseModel prepareFailView(String error) throws UserCreationFailed {
        throw new UserCreationFailed(error);
    }
}
