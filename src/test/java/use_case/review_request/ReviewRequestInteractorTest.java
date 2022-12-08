package use_case.review_request;

import data_access.IMReviewRequest;
import entity.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReviewRequestInteractorTest {
    @Test
    void testReviewRequest() {
        // initialize the environment with 1 dpt head and 1 employee
        Department dpt = new Department(UUID.randomUUID(), "Test Dpt", 0, new HashSet<>(List.of(1)),
                "a dpt", LocalDateTime.now());
        Map<Integer, User> users = new HashMap<>();
        Map<UUID, Task> tasks = new HashMap<>();

        List<Role> roles0 = Collections.singletonList(new RoleFactory().createCommonRole(Position.HEADOF, dpt));
        User head = new CommonUserFactory().create(0, dpt, "bio", "head", "pass0", roles0,
                new ArrayList<>(), new ArrayList<>(), Position.HEADOF, LocalDate.now());
        users.put(0, head);

        List<Role> roles1 = Collections.singletonList(new RoleFactory().createCommonRole(Position.MEMBER, dpt));
        User employee = new CommonUserFactory().create(1, dpt, "bio", "employee", "pass1",
                roles1, new ArrayList<>(), new ArrayList<>(), Position.MEMBER, LocalDate.now());
        users.put(1, employee);

        // initialize the leave request
        Curr.setUser(employee);
        Project project = new LeaveRequestProjectBuilder().createProject("Request", "d",
                new HashSet<>(List.of(0)), 6, LeaveType.VACATION);
        Task task = project.getTasks().get(0);
        tasks.put(task.getOid(), task);
        head.addCurrTask(task);
        head.addCurrProject(project);

        Curr.setUser(head);
        ReviewRequestDsGateway gateway = new IMReviewRequest(tasks, users);

        ReviewRequestOutputBoundary presenter = responseModel -> {
            assertEquals(true, task.getResults());  // check result was updated
            assertNotNull(task.getCloseTime()); // check task was closed
            assertNotNull(project.getCloseTime()); // check project was closed
            assertEquals("On Leave", employee.getStatus()); // check employee status updated
            assertEquals(8, employee.getVacationDays());
            assertTrue(employee.getProjects().isEmpty()); // check project and task removed when closed
            assertTrue(employee.getTasks().isEmpty());
            assertTrue(head.getProjects().isEmpty());
            assertTrue(head.getTasks().isEmpty());
            return null;
        };

        ReviewRequestInputBoundary interactor = new ReviewRequestInteractor(gateway, presenter);

        ReviewRequestRequestModel requestModel = new ReviewRequestRequestModel(task.getOid(), true);

        interactor.reviewRequest(requestModel);
    }
}
