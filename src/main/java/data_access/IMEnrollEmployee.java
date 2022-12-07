package data_access;

import enroll_employee.EnrollDsGateway;
import enroll_employee.EnrollDsRequestModel;
import entity.CommonUser;
import entity.Department;
import entity.User;

import java.time.LocalDateTime;
import java.util.*;

public class IMEnrollEmployee implements EnrollDsGateway {

    final List<CommonUser> users;
    final List<Department> departments;

    public IMEnrollEmployee() {
        Set<Integer> s = new HashSet<>();
        Department dpt1 = new Department(UUID.randomUUID(),"Department1",null,s,"NOTHING", LocalDateTime.now());
        Department dpt2 = new Department(UUID.randomUUID(),"Department2",null,s,"NOTHING", LocalDateTime.now());
        Department dpt3 = new Department(UUID.randomUUID(),"Department3",null,s,"NOTHING", LocalDateTime.now());
        CommonUser u1 = new CommonUser(100001,dpt1,"n/a","Amy Wang");
        u1.setUsername("Wang0000");
        CommonUser u2 = new CommonUser(100002,dpt1,"n/a","Hanna Zhang");
        u2.setUsername("Zhan0000");
        CommonUser u3 = new CommonUser(100003,dpt1,"n/a","Jack Qwe");
        u3.setUsername("Qwee0000");
        CommonUser u4 = new CommonUser(100004,dpt2,"n/a","Petter Ma");
        u4.setUsername("Maaa0000");
        CommonUser u5 = new CommonUser(100005,dpt2,"n/a","Jennifer Green");
        u5.setUsername("Gree0000");
        CommonUser u6 = new CommonUser(100006,dpt3,"n/a","Ben Zhang");
        u6.setUsername("Zhan0001");
        List<Department> departmentss = new ArrayList<>();
        departmentss.add(dpt1);
        departmentss.add(dpt2);
        departmentss.add(dpt3);
        List<CommonUser> userss = new ArrayList<>();
        userss.add(u1);
        userss.add(u2);
        userss.add(u3);
        userss.add(u4);
        userss.add(u5);
        userss.add(u6);
        this.users = userss;
        this.departments = departmentss;
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
