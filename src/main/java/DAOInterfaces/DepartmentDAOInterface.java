package DAOInterfaces;

import entity.Department;

import java.util.List;
import java.util.UUID;

public interface DepartmentDAOInterface {

    // create a Department
    public void createDepartment(Department department);

    // update a Department
    public void updateDepartment(Department department);

    // get all Departments
    public List<Department> getAllDepartments();

    // get one Department
    public Department getDepartment(UUID id);


}
