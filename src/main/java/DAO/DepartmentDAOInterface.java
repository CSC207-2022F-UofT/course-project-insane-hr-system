package DAO;

import entity.Department;

import java.util.List;
import java.util.UUID;

public interface DepartmentDAOInterface {

    // create a Department
    void createDepartment(Department department);

    // update a Department
    void updateDepartment(Department department);

    // get all Departments
    List<Department> getAllDepartments();

    // get one Department
    Department getDepartment(UUID id);


}
