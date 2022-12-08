package entity.user;

import entity.role.Position;
import entity.project.Project;
import entity.role.Role;
import entity.task.Task;

import java.time.LocalDate;
import java.util.List;

public interface User extends UserFace {

    UserFile getUserFile();

    void setUserFile(UserFile userFile);

    // access and modify userFile
    void addCurrProject(Project project);

    void addCurrTask(Task task);

    boolean removeCurrTask(Task task);

    boolean removeCurrProject(Project project);

    boolean addRole(Role role);

    boolean removeRole(Role role);

    // getter and setter for Fields in the UserFile

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    List<Project> getProjects();

    void setProjects(List<Project> projects);

    List<Task> getTasks();

    void setTasks(List<Task> tasks);

    Position getPosition();

    void setPosition(Position position);

    LocalDate getOnboardDate();

    void setOnboardDate(LocalDate onboardDate);

    LocalDate getDepartureDate();

    void setDepartureDate(LocalDate departureDate);

    String getStatus();

    void setStatus(String status);

    List<Role> getRoles();

    void setRoles(List<Role> roles);

    int getVacationDays();

    void setVacationDays(int vacationDays);
}
