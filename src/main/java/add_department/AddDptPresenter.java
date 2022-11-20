package add_department;

import enroll_employee.UserCreationFailed;

public interface AddDptPresenter {
    AddDptResponseModel prepareSuccessView(AddDptResponseModel dpt);
    AddDptResponseModel prepareFailView (String error) throws UserCreationFailed;
}
