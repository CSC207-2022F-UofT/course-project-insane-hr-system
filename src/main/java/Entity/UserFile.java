package Entity;

import java.time.LocalDate;
import java.util.List;

import static Entity.Constants.CLOSED;
import static Entity.Constants.OPEN;

class UserFile {
    private final int id;
    private String username;
    private String password;
    private List<Project> projects;
    private List<Task> tasks;
    private String position;
    private LocalDate onboardDate;
    private LocalDate departureDate;
    private String status;

    // construct the userFile for departed user.
    public UserFile(int id,
                    String username,
                    String password,
                    List<Project> projects,
                    List<Task> tasks,
                    String position,
                    LocalDate onboardDate,
                    LocalDate departureDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.projects = projects;
        this.tasks = tasks;
        this.position = position;
        this.onboardDate = onboardDate;
        this.departureDate = departureDate;
        this.status = CLOSED;
    }

    // construct the userFile for onboard user
    public UserFile(int id, String username, String password,
                    List<Project> projects, List<Task> tasks,
                    String position, LocalDate onboardDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.projects = projects;
        this.tasks = tasks;
        this.position = position;
        this.onboardDate = onboardDate;
        this.status = OPEN;
    }

    @Override
    public String toString() {
        return String.format("%s's File:\n ID: %d\n Position: %s\n Current Project: %s\n Current Tasks: %s\n ",
                this.username, this.id, this.position, this.projects.toString(), this.tasks.toString());
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
        return this.tasks.remove(project);
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
