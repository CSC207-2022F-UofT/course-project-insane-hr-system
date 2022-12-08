package initialize_company;

import DAO.DepartmentDAO;
import DAO.ProjectDAO;
import DAO.TaskDAO;
import DAO.UserDAO;
import DAOInterfaces.DepartmentDAOInterface;
import DAOInterfaces.ProjectDAOInterface;
import DAOInterfaces.TaskDAOInterface;
import DAOInterfaces.UserDAOInterface;
import data_access.CheckProfileUserIDMap;
import entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static data_access.CheckProfileUserIDMap.*;

public class Initialization {
    private final static DepartmentDAOInterface dptDB = new DepartmentDAO();
    private final static ProjectDAOInterface projectDB = new ProjectDAO();
    private final static TaskDAOInterface taskDB = new TaskDAO();
    private final static UserDAOInterface userDB = new UserDAO();

    public static void initialize() {
        User dptHead = new CommonUser(CheckProfileUserIDMap.headId);
        User manager1 = new CommonUser(CheckProfileUserIDMap.manager1Id);
        User manager2 = new CommonUser(CheckProfileUserIDMap.manager2Id);
        User ee01 = new CommonUser(CheckProfileUserIDMap.employee01Id);
        User ee11 = new CommonUser(CheckProfileUserIDMap.employee11Id);
        User ee12 = new CommonUser(CheckProfileUserIDMap.employee12Id);
        User ee21 = new CommonUser(CheckProfileUserIDMap.employee21Id);
        User ee22 = new CommonUser(CheckProfileUserIDMap.employee22Id);
        Department dpt = new Department(dptUUID, "TestDepartment1", dptHead.getId(), new HashSet<>(), "This is the first dpt", LocalDateTime.now());
        Project project1 = new CommonProject(project1UUID, "Project 1", manager1.getId(), new HashSet<>(), "This is the first Project", LocalDateTime.now(), dpt, new ArrayList<>(), 1000);
        Project project2 = new CommonProject(project2UUID, "Project 2", manager2.getId(), new HashSet<>(), "This is the second Project", LocalDateTime.now(), dpt, new ArrayList<>(), 1000);



        List<User> userPool = new ArrayList<>();
        List<Organization> orgPool = new ArrayList<>();

        userPool.add(dptHead);
        userPool.add(manager1);
        userPool.add(manager2);
        userPool.add(ee01);
        userPool.add(ee11);
        userPool.add(ee12);
        userPool.add(ee21);
        userPool.add(ee22);

        for (User user : userPool){
            dpt.addMember(user.getId());
            user.setName("User " + user.getId());
            user.setStatus(Constants.OPEN);
            user.setUsername("username" + user.getId());
            user.setPassword("psw");
            user.setBio("hello everyone! I am " + user.getName() + ". I am in department " + user.getDpt().getName() + ".");
            user.setDpt(dpt);
        }

        for (User user: userPool){
            userDB.createUser(user);
        }

        for (User user : userPool){
            user.setDpt(dpt);
        }



    }
//
//    {}
//
//        connectUserProject(manager1, project1);
//        connectUserProject(ee01, project1);
//        connectUserProject(ee11, project1);
//        connectUserProject(ee12, project1);
//        dpt.addProject(project1);
//
//        List<Integer> member1 = new ArrayList<>();
//        member1.add(manager1.getId());
//        member1.add(ee11.getId());
//        member1.add(ee12.getId());
//        member1.add(ee01.getId());
//
//        connectUserProject(manager2, project2);
//        connectUserProject(ee01, project2);
//        connectUserProject(ee21, project2);
//        connectUserProject(ee22, project2);
//        dpt.addProject(project2);
//
//        List<Integer> member2 = new ArrayList<>();
//        member2.add(manager2.getId());
//        member2.add(ee21.getId());
//        member2.add(ee22.getId());
//        member2.add(ee01.getId());
//
//
//        addTaskToEe(ee01, (CommonProject) project1, task1UUID);
//        addTaskToEe(ee01, (CommonProject) project2, task2UUID);
//        addTaskToEe(ee11, (CommonProject) project1, task3UUID);
//        addTaskToEe(ee12, (CommonProject) project1, task4UUID);
//        addTaskToEe(ee21, (CommonProject) project2, task5UUID);
//        addTaskToEe(ee22, (CommonProject) project2, task6UUID);
//
//        orgPool.add(project1);
//        orgPool.add(project2);
//        orgPool.add(dpt);
//        IRoleFactory roleFactory = new RoleFactory();
//        for (User user: userPool){
//            roleFactory.addRoleToUserBasedOnOrg(user);
//            PositionSetter.setPositionBasedOnGivenUser(user);
}
