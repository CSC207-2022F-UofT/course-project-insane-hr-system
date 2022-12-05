package my_dao;

import DAOInterfaces.DepartmentDAOInterface;
import entity.Department;

import java.util.List;
import java.util.UUID;

public class dptDao implements DepartmentDAOInterface {
    @Override
    public void createDepartment(Department department) {

    }

    @Override
    public void updateDepartment(Department department) {

    }

    @Override
    public List<Department> getAllDepartments() {
        return null;
    }

    @Override
    public Department getDepartment(UUID id) {
        return null;
    }
}
