package presenter;

import check_profile_validation.*;
import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

class CheckProfilePresenterTest {
    @BeforeEach
    void setUp() {

        User user = new CommonUser(2);
        User head = new CommonUser(0);
        User manager = new CommonUser(-1);
        Set<Integer> dptMember  = new HashSet<>();
        dptMember.add(manager.getId());
        dptMember.add(user.getId());
        dptMember.add(manager.getId());

        Set<Integer> proMember  = new HashSet<>();
        proMember.add(user.getId());


        Department dpt = new Department(UUID.randomUUID(), "TestDepartment1", head.getId(), dptMember, "This is the first dpt", LocalDateTime.now());
        Project project = new CommonProject(UUID.randomUUID(), "Project 1", manager.getId(), proMember, "This is the first Project", LocalDateTime.now(), dpt, new ArrayList<>(), 1000);
        dpt.addProject(project);

        project.addMember(user.getId());
        user.addCurrProject(project);

        user.setDpt(dpt);
        dpt.addMember(user.getId());
        dpt.addMember(manager.getId());
        Curr.setUser(user);
    }


    @Test
    void prepareOrgFrame() {
    }

    @Test
    void initialSetup() {
    }
}