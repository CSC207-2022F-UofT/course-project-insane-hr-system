package salary_calculator;

public class DataAccessException extends RuntimeException {
    public DataAccessException(String error) {
        super(error);
    }
}
