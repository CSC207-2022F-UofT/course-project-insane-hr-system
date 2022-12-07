package enroll_employee;

public interface EnrollOutputBoundary {
    EnrollResponseModel prepareSuccessView (EnrollResponseModel user);
    EnrollResponseModel prepareFailView (String error);
}
