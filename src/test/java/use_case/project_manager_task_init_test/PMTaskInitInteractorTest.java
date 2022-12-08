package use_case.project_manager_task_init_test;
import data_access.PMTaskInitDataAccess;
import entity.*;
import org.junit.jupiter.api.Test;
import presenter.PMTaskInitPresenter;
import project_manager_task_init_use_case.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PMTaskInitInteractorTest {
    @Test
    void testCreateTask() {
        //create test department, project, and 2 users (PM and employee)
        Department department = new Department(UUID.randomUUID(), "Fake Department", 0, new HashSet<>(List.of(1)),
                "a fake department for testing", LocalDateTime.now());

        List<Role> pm_roles = Collections.singletonList(new RoleFactory().createCommonRole(Position.HEADOF, department));
        List<Project> pm_projects = new ArrayList<>();
        List<Task> pm_tasks = new ArrayList<>();

        User pm = new CommonUserFactory().create(0, department, "bio", "pmusername", "password", pm_roles, pm_projects, pm_tasks, Position.HEADOF, LocalDate.now());

        List<Role> employee_roles = Collections.singletonList(new RoleFactory().createCommonRole(Position.MEMBER, department));
        List<Project> employee_projects = new ArrayList<>();
        List<Task> employee_tasks = new ArrayList<>();

        User employee = new CommonUserFactory().create(1, department, "bio1", "employeeusername", "employeepassword", employee_roles, employee_projects, employee_tasks, Position.MEMBER, LocalDate.now());

        Curr.setUser(pm);

        Set<Integer> members = new HashSet<>();
        members.add(pm.getId());
        members.add(employee.getId());
        List<Task> tasks = new ArrayList<>();
        Project project = new CommonProjectFactory().createOpenProject("project1", members, "description", LocalDateTime.now(), department, tasks, 1);

        pm.addCurrProject(project);
        employee.addCurrProject(project);

        //testing the interactor
        PMTaskInitGateway gateway = new PMTaskInitDataAccess();
        PMTaskInitPresenter presenter = new PMTaskInitPresenter() {
            @Override
            public PMTaskInitResponseModel prepareSuccessView(PMTaskInitResponseModel response) {
                assertEquals("name of task", response.getTaskName());
                assertEquals("description of task", response.getTaskDescription());
                assertEquals(1, response.getEmployeeId());
                return null;
            }
        };

        PMTaskInitInputBoundary interactor = new PMTaskInitInteractor(presenter, gateway);

        PMTaskInitRequestModel inputData = new PMTaskInitRequestModel("name of task", "description of task", 1);

        interactor.createTask(inputData);

    }

}
