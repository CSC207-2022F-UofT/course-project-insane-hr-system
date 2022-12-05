package data_access;


import DAO.DepartmentDAO;
import DAO.UserDAO;
import DAOInterfaces.DepartmentDAOInterface;
import DAOInterfaces.UserDAOInterface;
import enroll_employee.EnrollDsGateway;
import enroll_employee.EnrollDsRequestModel;
import entity.CommonUser;
import entity.Department;
import entity.User;

import java.util.*;

public class EnrollDataAccess implements EnrollDsGateway {

    private final UserDAOInterface userDAOInterface = new UserDAO();
    private final DepartmentDAOInterface departmentDAOInterface = new DepartmentDAO();


    @Override
    public List<String> getAllUserLastName() {
        List<String> names = new ArrayList<>();
        List<CommonUser> users = userDAOInterface.getAllUsers();
        for (CommonUser user: users){
            String[] fullName = user.getName().split(" ");
            names.add(fullName[1]);
        }
        return names;
    }

    @Override
    public List<Integer> getAllUID() {
        List<Integer> ids = new ArrayList<>();
        List<CommonUser> users = userDAOInterface.getAllUsers();
        for (CommonUser user: users){
            ids.add(user.getId());
        }
        return ids;
    }

    @Override
    public String generateUsername(String name) {
        List<String> allNames = getAllUserLastName();
        StringBuilder nameBuilder = new StringBuilder(name);
        while (nameBuilder.length() < 4){
            nameBuilder.append(nameBuilder.charAt(0));
        }
        name = nameBuilder.toString();
        String firstPart = name.substring(0,4);
        int i = 0;
        for (String n: allNames){
            if (n.substring(0,4).equals(firstPart)){
                i = i + 1;
            }
        }
        String secondPart = String.format("%04d", i);
        return firstPart + secondPart;
    }

    @Override
    public int generateId() {
        List<Integer> ids = getAllUID();
        if (ids.size() == 0){
            return 100001;
        }
        return Collections.max(ids)+1;
    }

    @Override
    public void save(EnrollDsRequestModel requestModel) {
        User user = requestModel.getUser();
        CommonUser commonUser = new CommonUser(user.getId(),user.getDpt(), user.getBio(), user.getUserFile());
        userDAOInterface.createUser(commonUser);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDAOInterface.getAllDepartments();
    }

    @Override
    public void updateDepartment(Department dpt) {
        departmentDAOInterface.updateDepartment(dpt);
    }


    @Override
    public Department findDptByName(String name) {
        List<Department> dpts = getAllDepartments();
        for (Department dpt: dpts){
            if (dpt.getName().equals(name)){
                return dpt;
            }
        }
        return null;
    }
}
