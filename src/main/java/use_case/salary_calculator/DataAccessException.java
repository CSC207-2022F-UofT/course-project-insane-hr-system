package use_case.salary_calculator;

public class DataAccessException extends RuntimeException {
    public DataAccessException(String error) {
        super(error);
    }
}
