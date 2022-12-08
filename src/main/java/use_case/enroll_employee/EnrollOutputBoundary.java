package use_case.enroll_employee;

public interface EnrollOutputBoundary {
    EnrollResponseModel prepareSuccessView (EnrollResponseModel user);
    EnrollResponseModel prepareFailView (String error);
}
