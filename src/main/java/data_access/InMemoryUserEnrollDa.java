package data_access;

import enroll_employee.EnrollDsGateway;
import enroll_employee.EnrollDsRequestModel;
import entity.Department;

import java.util.List;

public class InMemoryUserEnrollDa implements EnrollDsGateway {
    /**
     * @return
     */
    @Override
    public List<String> getAllUserLastName() {
        return ["Eva ", ]
    }

    /**
     * @return
     */
    @Override
    public List<Integer> getAllUID() {
        return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public String generateUsername(String name) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public int generateId() {
        return 0;
    }

    /**
     * @param requestModel
     */
    @Override
    public void save(EnrollDsRequestModel requestModel) {

    }

    /**
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {
        return null;
    }

    /**
     * @param dpt
     */
    @Override
    public void updateDepartment(Department dpt) {

    }

    /**
     * @param name
     * @return
     */
    @Override
    public Department findDptByName(String name) {
        return null;
    }
}
