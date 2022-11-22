package enroll_employee;

import entity.Department;

import java.util.List;

public interface EnrollDsGateway {
    List<String> getAllUsername();
    List<Integer> getAllUID();

    String generateUsername(String name); //first four letter of last name + four numbers e.g. zhan0001,zhan0002
    int generateId(); //six digit, which is the number of employees plus one, starting from 100001
    void save(EnrollDsRequestModel requestModel); //requestModel contains a User entity
    List<Department> getAllDepartments(); //return a List containing all the current department entity

    void updateDepartment(Department dpt); // add a user into department

    Department findDptByName(String name); // use the department name to find the department


}
