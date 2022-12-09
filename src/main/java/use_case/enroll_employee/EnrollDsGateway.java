package use_case.enroll_employee;

import entity.Department;

import java.util.List;

public interface EnrollDsGateway {
    //The interface for data access to implement

    /**
     * To generate username, this method can get the last four letter of the user's last name.
     * @return A list of string that are the last four letter of the user's last name
     */
    List<String> getUserNameLastFour();

    /**
     * return the user ids
     * @return a list of intergers that are the ids of all the users.
     */
    List<Integer> getAllUID();

    /**
     *
     * @param name is the last name of the new employee
     * @return a generated username. For example, the new employee's last name is Zhang, and
     * three current employees also have the same last name Zhang, then the new user's username will be
     * zhan0003
     */
    String generateUsername(String name); //first four letter of last name + four numbers e.g. zhan0001,zhan0002

    /**
     *
     * @return the generated id. The id starts with 100001, increasing by 1 when we are adding a new employee.
     */
    int generateId(); //six digit, which is the number of employees plus one, starting from 100001

    /**
     * save the new user into our database.
     * @param requestModel contains the user information that we want to save in the database.
     */
    void save(EnrollDsRequestModel requestModel); //requestModel contains a User entity

    /**
     * return all the departments in our database.
     * @return dapartments
     */
    List<Department> getAllDepartments(); //return a List containing all the current department entity

    /**
     * Update the department since we added a department head.
     * @param dpt is the department that need to be updated.
     */
    void updateDepartment(Department dpt); // add a user into department

    /**
     * Based on the department name to find the corresponding department entity.
     * @param name is the name of the department
     * @return the department that has the name that we need
     */
    Department findDptByName(String name); // use the department name to find the department


}
