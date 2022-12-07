package data_access;

import enroll_employee.EnrollDsGateway;
import enroll_employee.EnrollDsRequestModel;
import entity.CommonUser;
import entity.Department;
import entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IMEnrollEmployee implements EnrollDsGateway {

    final List<CommonUser> users;
    final List<Department> departments;

    public IMEnrollEmployee(List<CommonUser> users, List<Department> departments) {
        this.users = users;
        this.departments = departments;
    }

    @Override
    public List<String> getUserNameLastFour() {
        List<String> names = new ArrayList<>();
        for (CommonUser user: users){
            names.add(user.getUsername().substring(0,4));
        }
        return names;
    }

    @Override
    public List<Integer> getAllUID() {
        List<Integer> ids = new ArrayList<>();
        for (CommonUser user: users){
            ids.add(user.getId());
        }
        return ids;
    }

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
        users.add(commonUser);
        System.out.println(users.get(users.size()-1));
    }

    @Override
    public List<Department> getAllDepartments() {
        return departments;
    }

    @Override
    public void updateDepartment(Department dpt) {
        for (int i =0; i < departments.size(); i++)
            if (departments.get(i).getOid() == dpt.getOid()){
                departments.set(i,dpt);
            }
    }

    @Override
    public Department findDptByName(String name) {

        for (Department dpt: departments){
            if (dpt.getName().equals(name)){
                return dpt;
            }
        }
        return null;
    }
}
