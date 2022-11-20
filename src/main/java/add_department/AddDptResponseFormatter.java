package add_department;

import enroll_employee.UserCreationFailed;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddDptResponseFormatter implements AddDptPresenter{


    @Override
    public AddDptResponseModel prepareSuccessView(AddDptResponseModel dpt) {
        LocalDateTime responseTime = LocalDateTime.now();
        dpt.setCreationTime(LocalDate.from(responseTime));
        return responseModel;
    }

    @Override
    public AddDptResponseModel prepareFailView(String error) throws UserCreationFailed {
        return null;
    }
}
