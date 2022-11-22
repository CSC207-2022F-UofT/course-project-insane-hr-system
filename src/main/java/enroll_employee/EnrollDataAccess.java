package enroll_employee;

import entity.Department;

import java.time.LocalDateTime;
import java.util.*;

public class EnrollDataAccess implements EnrollDsGateway {

    @Override
    public List<String> getAllUsername() {
        return null;
    }

    @Override
    public List<Integer> getAllUID() {
        return null;
    }

    @Override
    public String generateUsername(String name) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void save(EnrollDsRequestModel requestModel) {

    }

    @Override
    public List<Department> getAllDepartments() {
        Set s = new HashSet();
        Department dpt1 = new Department(UUID.randomUUID(),"dpta",2,s,"NOTHING", LocalDateTime.now());
        Department dpt2 = new Department(UUID.randomUUID(),"dptb",2,s,"NOTHING", LocalDateTime.now());
        Department dpt3 = new Department(UUID.randomUUID(),"dptc",2,s,"NOTHING", LocalDateTime.now());
        List<Department> dpts = new ArrayList<>();
        dpts.add(dpt1);
        dpts.add(dpt2);
        dpts.add(dpt3);
        return dpts;
    }

    @Override
    public void updateDepartment(Department dpt) {

    }


    @Override
    public Department findDptByName(String name) {
        return null;
    }
}
