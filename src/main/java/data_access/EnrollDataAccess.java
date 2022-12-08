package data_access;


import DAO.DepartmentDAO;
import DAO.UserDAO;
import DAO.DepartmentDAOInterface;
import DAO.UserDAOInterface;
import use_case.enroll_employee.EnrollDsGateway;
import use_case.enroll_employee.EnrollDsRequestModel;
import entity.user.CommonUser;
import entity.Department;
import entity.user.User;

import java.util.*;

public class EnrollDataAccess implements EnrollDsGateway {

    private final UserDAOInterface userDAOInterface = new UserDAO();
    private final DepartmentDAOInterface departmentDAOInterface = new DepartmentDAO();

    /**
     * @return the first four letter of the last name of all users
     */
    @Override
    public List<String> getUserNameLastFour() {
        List<String> names = new ArrayList<>();
        List<User> users = userDAOInterface.getAllUsers();
        for (User user: users){
            names.add(user.getUsername().substring(0,4));
        }
        return names;
    }

    /**
     * @return the uid of all users
     */
    @Override
    public List<Integer> getAllUID() {
        List<Integer> ids = new ArrayList<>();
        List<User> users = userDAOInterface.getAllUsers();
        for (User user: users){
            ids.add(user.getId());
        }
        return ids;
    }

    /**
     * @param name is the username
     * @return a generated username
     */
    @Override
    public String generateUsername(String name) {
        List<String> allUsernameLastFour = getUserNameLastFour();
        StringBuilder nameBuilder = new StringBuilder(name.split(" ")[1]);
        while (nameBuilder.length() < 4){
            nameBuilder.append(nameBuilder.charAt(nameBuilder.length()-1));
        }
        name = nameBuilder.toString();
        String firstPart = name.substring(0,4);
        int i = 0;
        for (String n: allUsernameLastFour){
            if (n.equals(firstPart)){
                i = i + 1;
            }
        }
        String secondPart = String.format("%04d", i);
        return firstPart + secondPart;
    }

    /**
     * @return the generated id
     */
    @Override
    public int generateId() {
        List<Integer> ids = getAllUID();
        if (ids.size() == 0){
            return 100001;
        }
        return Collections.max(ids)+1;
    }

    /**
     * @param requestModel contains the new user
     */
    @Override
    public void save(EnrollDsRequestModel requestModel) {
        User user = requestModel.getUser();
        CommonUser commonUser = new CommonUser(user.getId(),user.getDpt(), user.getBio(), user.getUserFile());
        commonUser.setName(user.getName());
        userDAOInterface.createUser(commonUser);
    }

    /**
     * @return all the department
     */
    @Override
    public List<Department> getAllDepartments() {
        return departmentDAOInterface.getAllDepartments();
    }

    /**
     * @param dpt the department that will be updated in the database.
     */
    @Override
    public void updateDepartment(Department dpt) {
        departmentDAOInterface.updateDepartment(dpt);
    }

    /**
     * @param name the department name that is used to find the department
     * @return the department that has the given name
     */
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
