package data_access;

import use_case.check_profile_validation.CheckProfileIGateway;
import entity.*;

import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import static data_access.CheckProfileUserIDMap.*;

public class CheckProfileIMDataAccess implements CheckProfileIGateway {
//    @Override
//    public List<Role> getUserRolesByUid(Integer target) {
//        return null;
//    }


    private final User dptHead = new CommonUser(CheckProfileUserIDMap.headId);
    private final User manager1 = new CommonUser(CheckProfileUserIDMap.manager1Id);
    private final User manager2 = new CommonUser(CheckProfileUserIDMap.manager2Id);
    private final User ee01 = new CommonUser(CheckProfileUserIDMap.employee01Id);
    private final User ee11 = new CommonUser(CheckProfileUserIDMap.employee11Id);
    private final User ee12 = new CommonUser(CheckProfileUserIDMap.employee12Id);
    private final User ee21 = new CommonUser(CheckProfileUserIDMap.employee21Id);
    private final User ee22 = new CommonUser(CheckProfileUserIDMap.employee22Id);
    private final Department dpt = new Department(dptUUID, "TestDepartment1", dptHead.getId(), new HashSet<>(), "This is the first dpt", LocalDateTime.now());
    private final Project project1 = new CommonProject(project1UUID, "Project 1", manager1.getId(), new HashSet<>(), "This is the first Project", LocalDateTime.now(), dpt, new ArrayList<>(), 1000);
    private final Project project2 = new CommonProject(project2UUID, "Project 2", manager2.getId(), new HashSet<>(), "This is the second Project", LocalDateTime.now(), dpt, new ArrayList<>(), 1000);

    private final List<User> userPool = new ArrayList<>();
    private final List<Organization> orgPool = new ArrayList<>();

    public CheckProfileIMDataAccess() {
        userPool.add(dptHead);
        userPool.add(manager1);
        userPool.add(manager2);
        userPool.add(ee01);
        userPool.add(ee11);
        userPool.add(ee12);
        userPool.add(ee21);
        userPool.add(ee22);

        for (User user : userPool){
            user.setDpt(dpt);
            dpt.addMember(user.getId());
            user.setName("User " + user.getId());
            user.setStatus(Constants.OPEN);
            user.setUsername("username" + user.getId());
            user.setPassword("psw" + user.getId());
            user.setBio("hello everyone! I am " + user.getName() + ". I am in department " + user.getDpt().getName() + ".");


        }

        connectUserProject(manager1, project1);
        connectUserProject(ee01, project1);
        connectUserProject(ee11, project1);
        connectUserProject(ee12, project1);
        dpt.addProject(project1);

        List<Integer> member1 = new ArrayList<>();
        member1.add(manager1.getId());
        member1.add(ee11.getId());
        member1.add(ee12.getId());
        member1.add(ee01.getId());

        connectUserProject(manager2, project2);
        connectUserProject(ee01, project2);
        connectUserProject(ee21, project2);
        connectUserProject(ee22, project2);
        dpt.addProject(project2);

        List<Integer> member2 = new ArrayList<>();
        member2.add(manager2.getId());
        member2.add(ee21.getId());
        member2.add(ee22.getId());
        member2.add(ee01.getId());


        addTaskToEe(ee01, (CommonProject) project1, task1UUID);
        addTaskToEe(ee01, (CommonProject) project2, task2UUID);
        addTaskToEe(ee11, (CommonProject) project1, task3UUID);
        addTaskToEe(ee12, (CommonProject) project1, task4UUID);
        addTaskToEe(ee21, (CommonProject) project2, task5UUID);
        addTaskToEe(ee22, (CommonProject) project2, task6UUID);

        orgPool.add(project1);
        orgPool.add(project2);
        orgPool.add(dpt);
        IRoleFactory roleFactory = new RoleFactory();
        for (User user: userPool){
            roleFactory.addRoleToUserBasedOnOrg(user);
            PositionSetter.setPositionBasedOnGivenUser(user);
        }
    }

    private void connectUserProject(User user, Project project) {
        user.addCurrProject(project);
        project.addMember(user.getId());
    }
    private void addTaskToEe(User user, CommonProject project, UUID taskID){
        Task task = new CommonTask(taskID, "Task of " + user.getName(), project.getHead(), "This is the task for employee " + user.getName(), LocalDateTime.now(), project);
        user.addCurrTask(task);
        project.addTask(task);
        User manager = getUserByUid(project.getHead());
        manager.addCurrTask(task);
        task.addMember(user.getId());
        task.addMember(manager.getId());

        task.setDescription("This is " + user.getName() + "'s task in project " + project.getName());
        orgPool.add(task);
    }

    @Override
    public User getUserByUid(Integer target) {

        for (User user:userPool){
            if (user.getId() == target){
                return user;
            }
        }
        return null;
    }

//    @Override
//    public PropertyChangeSupport getObservable() {
//        return null;
//    }

    @Override
    public void addObserver(PropertyChangeListener observer) {

    }

    @Override
    public Organization getOrgByOid(UUID oid) {

        for (Organization organization1 : orgPool){
            if (organization1.getOid().equals(oid)){
                return organization1;
            }
        }

        return null;
    }

//    @Override
//    public User getFakeUserByUid(Integer target) {
//       
//    }

    public static void main(String[] args) {
        CheckProfileIMDataAccess gateway = new CheckProfileIMDataAccess();
        for (User user : gateway.getUserPool()) {
            System.out.println(user);
        }
//        for (Organization organization : gateway.getOrgPool()){
//            System.out.println(organization);
//        }
    }

    public List<User> getUserPool() {
        return userPool;
    }

    public List<Organization> getOrgPool() {
        return orgPool;
    }

    public User getDptHead() {
        return dptHead;
    }

    public User getManager1() {
        return manager1;
    }

    public User getManager2() {
        return manager2;
    }

    public User getEe01() {
        return ee01;
    }

    public User getEe11() {
        return ee11;
    }

    public User getEe12() {
        return ee12;
    }

    public User getEe21() {
        return ee21;
    }

    public User getEe22() {
        return ee22;
    }

    public Department getDpt() {
        return dpt;
    }

    public Project getProject1() {
        return project1;
    }

    public Project getProject2() {
        return project2;
    }

}
