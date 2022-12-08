package use_case.leave_request;

import data_access.IMLeaveRequest;
import entity.*;
import entity.project.LeaveRequestProjectBuilder;
import entity.project.Project;
import entity.project.ProjectBuilder;
import entity.role.Position;
import entity.role.Role;
import entity.role.RoleFactory;
import entity.task.Task;
import entity.user.CommonUserFactory;
import entity.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class LeaveRequestInteractorTest {
    @Test
    void testCreate() {
        // initialize the environment with 1 dpt head and 1 employee
        Department dpt = new Department(UUID.randomUUID(), "Test Dpt", 0, new HashSet<>(List.of(1)),
                "a dpt", LocalDateTime.now());
        Map<Integer, User> users = new HashMap<>();
        Map<UUID, Project> projects = new HashMap<>();
        Map<UUID, Task> tasks = new HashMap<>();

        List<Role> roles0 = Collections.singletonList(new RoleFactory().createCommonRole(Position.HEADOF, dpt));
        User head = new CommonUserFactory().create(0, dpt, "bio", "head", "pass0", roles0,
                new ArrayList<>(), new ArrayList<>(), Position.HEADOF, LocalDate.now());
        users.put(0, head);

        List<Role> roles1 = Collections.singletonList(new RoleFactory().createCommonRole(Position.MEMBER, dpt));
        User employee = new CommonUserFactory().create(1, dpt, "bio", "employee", "pass1",
                roles1, new ArrayList<>(), new ArrayList<>(), Position.MEMBER, LocalDate.now());
        users.put(1, employee);

        Curr.setUser(employee);
        LeaveRequestDsGateway gateway = new IMLeaveRequest(users, projects, tasks);

        LeaveRequestOutputBoundary presenter = new LeaveRequestOutputBoundary() {
            @Override
            public LeaveRequestResponseModel prepareSuccessView(LeaveRequestResponseModel response) {
                assertFalse(projects.isEmpty());
                assertFalse(tasks.isEmpty());
                assertFalse(head.getTasks().isEmpty());  // check if leave request task saved
                assertFalse(head.getProjects().isEmpty());
                assertFalse(employee.getTasks().isEmpty());
                assertFalse(employee.getProjects().isEmpty()); // check if leave request project saved
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

        LeaveRequestRequestModel requestModel = new LeaveRequestRequestModel(employee, "m", LeaveType.VACATION,
                LocalDate.of(2022, 9, 1), LocalDate.of(2022, 9, 7));

        interactor.create(requestModel);
    }
}
