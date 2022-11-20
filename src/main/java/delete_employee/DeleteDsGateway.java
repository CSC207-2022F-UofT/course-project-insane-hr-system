package delete_employee;

public interface DeleteDsGateway {
    boolean existsById(int id);
    boolean delete(int id); //search for the id and delete the employee.
}
