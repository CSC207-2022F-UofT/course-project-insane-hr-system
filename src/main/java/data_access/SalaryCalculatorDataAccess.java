package data_access;

import DAO.DepartmentDAOInterface;
import DAO.ProjectDAOInterface;
import DAO.TaskDAOInterface;
import DAO.UserDAOInterface;
import entity.Project;
import entity.Task;
import entity.User;
import my_dao.dptDao;
import my_dao.projectDao;
import my_dao.taskDao;
import my_dao.userDao;
import use_case.salary_calculator.SalaryCalculatorGateway;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SalaryCalculatorDataAccess implements SalaryCalculatorGateway {

    private final DepartmentDAOInterface departmentDAO = new dptDao();
    private final UserDAOInterface userDAOInterface = new userDao();
    private final TaskDAOInterface taskDAOInterface = new taskDao();
    private final ProjectDAOInterface projectDAOInterface = new projectDao();

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
