package employeeEnroll;

public interface EnrollPresenter {
    EnrollResponseModel prepareSuccessView (EnrollResponseModel user);
    EnrollResponseModel prepareFailView (String error) throws UserCreationFailed;
}
