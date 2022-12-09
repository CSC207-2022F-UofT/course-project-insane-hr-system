package use_case.enroll_employee;

public class UserCreationFailed extends RuntimeException {

    // exceptions for user input blank name.
    public UserCreationFailed(String error) {
        super(error);
    }
}