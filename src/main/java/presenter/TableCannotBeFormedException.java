package presenter;

public class TableCannotBeFormedException extends Throwable {
    public TableCannotBeFormedException(IllegalAccessException e) {
        throw new RuntimeException("Table can not be formed!");
    }
}
