package data_access;

import check_profile_validation.CheckProfileIGateway;
import entity.*;

import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class CheckProfileTestDataAccess implements CheckProfileIGateway {
//    @Override
//    public List<Role> getUserRolesByUid(Integer target) {
//        return null;
//    }

    @Override
    public User getUserByUid(Integer target) {

        User user = new CommonUser(0);
        User head = new CommonUser(2);
        User manager = new CommonUser(1);

        user.setPosition(Position.MEMBER);
        head.setPosition(Position.HEAD);
        manager.setPosition(Position.HEAD);

        Department dpt = new Department(UUID.randomUUID(), "TestDepartment1", head.getId(), new HashSet<>(target), "This is the first dpt", LocalDateTime.now());
        Project project = new CommonProject(UUID.randomUUID(), "Project 1", manager.getId(), new HashSet<>(user.getId()), "This is the first Project", LocalDateTime.now(), dpt, new ArrayList<>(), 1000);
        dpt.addProject(project);
        
        project.addMember(user.getId());
        user.addCurrProject(project);
        
        user.setDpt(dpt);
        manager.setDpt(dpt);
        head.setDpt(dpt);
        dpt.addMember(user.getId());
        dpt.addMember(manager.getId());
        
        if (target == 0) {
            return user;
        }else if (target==1){
            return manager;
        }else if (target==2) {
            return head;
        }
        return user;
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

        User user = new CommonUser(2);
        User head = new CommonUser(0);
        User manager = new CommonUser(-1);


        Department dpt = new Department(UUID.randomUUID(), "TestDepartment1", head.getId(), new HashSet<>(manager.getId(), user.getId()), "This is the first dpt", LocalDateTime.now());
        Project project = new CommonProject(UUID.randomUUID(), "Project 1", manager.getId(), new HashSet<>(user.getId()), "This is the first Project", LocalDateTime.now(), dpt, new ArrayList<>(), 1000);
        dpt.addProject(project);

        project.addMember(user.getId());
        user.addCurrProject(project);

        user.setDpt(dpt);
        dpt.addMember(user.getId());
        dpt.addMember(manager.getId());

        return project;
    }

//    @Override
//    public User getFakeUserByUid(Integer target) {
//       
//    }
}