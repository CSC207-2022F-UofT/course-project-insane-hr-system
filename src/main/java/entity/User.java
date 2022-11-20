package entity;

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

    boolean addRole(String role);

    boolean removeRole(String role);

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

    List<String> getRoles();

    void setRoles(List<String> roles);

    int getVacationDays();

    void setVacationDays(int vacationDays);
}
