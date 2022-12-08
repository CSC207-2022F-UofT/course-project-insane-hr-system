package use_case.unused_delete_employee;

import entity.Curr;
import entity.User;

import java.util.List;

public interface DeleteDsGateway {
    List<User> getEmployees(Curr curr); // return a list containing all the employees under the current department Head or CEO.
    boolean delete(User user); //search for the id and delete the employee.
}
