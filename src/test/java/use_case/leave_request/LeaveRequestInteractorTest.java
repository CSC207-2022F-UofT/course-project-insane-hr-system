package use_case.leave_request;

import data_access.IMLeaveRequest;
import entity.*;
import leave_request.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class LeaveRequestInteractorTest {
    @Test
    void testCreate() {
        // initialize the environment with 1 dpt head and 1 user
        Department dpt = new Department(UUID.randomUUID(), "Test Dpt", 0, new HashSet<>(List.of(1)),
                "a dpt", LocalDateTime.now());
        Map<Integer, User> users = new HashMap<>();
        List<Role> roles0 = Collections.singletonList(new RoleFactory().createCommonRole(Position.HEADOF, dpt));
        User user0 = new CommonUserFactory().create(0, dpt, "bio", "user0", "pass0", roles0,
                new ArrayList<>(), new ArrayList<>(), Position.HEADOF, LocalDate.now());
        users.put(0, user0);
        List<Role> roles1 = Collections.singletonList(new RoleFactory().createCommonRole(Position.MEMBER, dpt));
        User user1 = new CommonUserFactory().create(1, dpt, "bio", "user1", "pass1", roles1,
                new ArrayList<>(), new ArrayList<>(), Position.MEMBER, LocalDate.now());
        users.put(1, user1);
        Curr.setUser(user1);
        Map<UUID, Project> projects = new HashMap<>();
        Map<UUID, Task> tasks = new HashMap<>();

        LeaveRequestDsGateway gateway = new IMLeaveRequest(users, projects, tasks);

        LeaveRequestOutputBoundary presenter = new LeaveRequestOutputBoundary() {
            @Override
            public LeaveRequestResponseModel prepareSuccessView(LeaveRequestResponseModel response) {
                assertFalse(projects.isEmpty());
                assertFalse(tasks.isEmpty());
                assertFalse(user0.getTasks().isEmpty());  // check if leave request task saved
                assertFalse(user1.getProjects().isEmpty()); // check if leave request project saved
                return null;
            }

            @Override
            public LeaveRequestResponseModel prepareFailureView(String error) {
                fail("Use case failure is expected");
                return null;
            }
        };

        ProjectBuilder projectBuilder = new LeaveRequestProjectBuilder();
        LeaveRequestInputBoundary interactor = new LeaveRequestInteractor(gateway, presenter, projectBuilder);

        LeaveRequestRequestModel requestModel = new LeaveRequestRequestModel(user1, "Please", LeaveType.VACATION,
                LocalDate.of(2022, 9, 1), LocalDate.of(2022, 9, 7));

        interactor.create(requestModel);
    }
}
