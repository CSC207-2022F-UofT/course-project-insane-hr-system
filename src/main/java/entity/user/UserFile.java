package entity.user;

import entity.role.Position;
import entity.project.Project;
import entity.role.Role;
import entity.task.Task;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static entity.Constants.CLOSED;
import static entity.Constants.OPEN;

class UserFile implements Serializable {
    private final int id;
    private String username;
    private String password;
    private List<Role> roles = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private Position position; // employees are member, managers dpt Heads are heads and CEOs are CEO
    private LocalDate onboardDate;
    private LocalDate departureDate;
    private String status;
    private int vacationDays = 14;

    // construct the userFile for departed user.
    public UserFile(int id,
                    String username,
                    String password,
                    List<Role> roles, List<Project> projects,
                    List<Task> tasks,
                    Position position,
                    LocalDate onboardDate,
                    LocalDate departureDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.projects = projects;
        this.tasks = tasks;
        this.position = position;
        this.onboardDate = onboardDate;
        this.departureDate = departureDate;
        this.status = CLOSED;
    }

    // construct the userFile for onboard user
    public UserFile(int id, String username, String password,
                    List<Role> roles, List<Project> projects, List<Task> tasks,
                    Position position, LocalDate onboardDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.projects = projects;
        this.tasks = tasks;
        this.position = position;
        this.onboardDate = onboardDate;
        this.status = OPEN;
    }

    public UserFile(int id) {
        this.id = id;
    }


    public String getName() {
        return this.username;
    }

    // CurrProjects and CurrTasks adding and removing
    public void addCurrProject(Project project) {
        this.projects.add(project);
    }

    public void addCurrTask(Task task) {
        this.tasks.add(task);
    }

    public boolean removeCurrTask(Task task) {
        return this.tasks.remove(task);
    }

    public boolean removeCurrProject(Project project) {
        return this.projects.remove(project);
    }


    // getter and setter
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getOnboardDate() {
        return onboardDate;
    }

    public void setOnboardDate(LocalDate onboardDate) {
        this.onboardDate = onboardDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getStatus() {
        switch (status) {
            case OPEN: return "Available";
            case CLOSED: return "Departed from Company";
        }
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean addRole(Role role) {
        return this.roles.add(role);
    }

    public boolean removeRole(Role role) {
        return this.roles.remove(role);
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    /**
     * @param obj any object.
     * @return true if the uid are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserFace) {
            return this.getId() == ((UserFace) obj).getId();
        } else if (obj instanceof UserFile) {
            return this.getId() == ((UserFile) obj).getId();
        }
        return false;
    }

    @Override
    public String toString() {
        return "UserFile{" + '\n' +
                "id=" + id +'\n' +
                ", username='" + username + '\'' +'\n' +
                ", password='" + password + '\'' +'\n' +
                ", roles=" + roles +'\n' +
                ", projects=" + projects +'\n' +
                ", tasks=" + tasks +'\n' +
                ", position=" + position +'\n' +
                ", onboardDate=" + onboardDate +'\n' +
                ", departureDate=" + departureDate +'\n' +
                ", status='" + status + '\'' +'\n' +
                ", vacationDays=" + vacationDays +'\n' +
                '}';
    }
}
