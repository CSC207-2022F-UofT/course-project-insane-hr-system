package add_department;

public class CreationFailed extends RuntimeException {

    public CreationFailed(String error) {
        super(error);
    }
}