package data_access;

import DAO.*;
import entity.Project;
import entity.Task;
import entity.User;

import use_case.salary_calculator.SalaryCalculatorGateway;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SalaryCalculatorDataAccess implements SalaryCalculatorGateway {

    private final DepartmentDAOInterface departmentDAO = new DepartmentDAO();
    private final UserDAOInterface userDAOInterface = new UserDAO();
    private final TaskDAOInterface taskDAOInterface = new TaskDAO();
    private final ProjectDAOInterface projectDAOInterface = new ProjectDAO();

    @Override
    public User getUserInPeriod(Integer targetID, LocalDate startDate, LocalDate endDate) throws IllegalArgumentException {

        User user = userDAOInterface.getUser(targetID);
        List<Task> tasks= taskDAOInterface.getAllTasks();
        List<Task> usersTasks = new ArrayList<>();
        for (Task task : tasks){
            LocalDateTime time = task.getCloseTime();
            if (task.getMembers().contains(targetID)&& time.compareTo(startDate.atStartOfDay()) > 0 && time.compareTo(endDate.atStartOfDay()) < 0) {
                usersTasks.add(task);
            }
        }

        List<Project> projects = projectDAOInterface.getAllProjects();
        List<Project> usersProjects = new ArrayList<>();
        for (Project project:projects){
            LocalDateTime time = project.getCloseTime();
            if (project.getMembers().contains(targetID) && time.compareTo(startDate.atStartOfDay()) > 0 && time.compareTo(endDate.atStartOfDay()) < 0){
                usersProjects.add(project);
            }
        }
        user.setTasks(usersTasks);
        user.setProjects(usersProjects);
        return user;
    }

    @Override
    public User getUserByUserID(Integer targetID) {
        return userDAOInterface.getUser(targetID);
    }
}
