package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommonUser extends CommonUserFace implements User {
    private UserFile userFile;

    //constructors
    //construct only with the initial uid
    public CommonUser(int uid) {
        super(uid);
        this.userFile = new UserFile(uid);
    }

    // construct without UserFile
    public CommonUser(int uid, Department dpt, String bio, String name) {
        super(uid, dpt, bio, name);
    }

    //construct with UserFile
    public CommonUser(int uid, Department dpt, String bio, UserFile userFile) {
        super(uid);
        this.dpt = dpt;
        this.bio = bio;
        this.userFile = userFile;
    }




    // getters and setters

    @Override
    public UserFile getUserFile() {
        return this.userFile;
    }
    @Override
    public void setUserFile(UserFile userFile) {
        this.userFile = userFile;
    }

    // access and modify userFile
    @Override
    public void addCurrProject(Project project) {
        this.userFile.getProjects().add(project);
    }

    @Override
    public void addCurrTask(Task task) {
        this.userFile.getTasks().add(task);
    }

    @Override
    public boolean removeCurrTask(Task task) {
        return this.userFile.getTasks().remove(task);
    }

    @Override
    public boolean removeCurrProject(Project project) {
        return this.userFile.getProjects().remove(project);
    }

    @Override
    public boolean addRole(Role role) {
        return this.userFile.getRoles().add(role);
    }

    @Override
    public boolean removeRole(Role role) {
        return this.userFile.getRoles().remove(role);
    }

    @Override
    public String getUsername() {
        return this.userFile.getUsername();
    }

    @Override
    public void setUsername(String username) {
        this.userFile.setUsername(username);
    }

    @Override
    public String getPassword() {
        return this.userFile.getPassword();
    }

    @Override
    public void setPassword(String password) {
        this.userFile.setPassword(password);
    }

    @Override
    public List<Project> getProjects() {
        return this.userFile.getProjects();
    }

    @Override
    public void setProjects(List<Project> projects) {
        this.userFile.setProjects(projects);
    }

    @Override
    public List<Task> getTasks() {
        return this.userFile.getTasks();
    }

    @Override
    public void setTasks(List<Task> tasks) {
        this.userFile.setTasks(tasks);
    }

    @Override
    public Position getPosition() {
        return this.userFile.getPosition();
    }

    @Override
    public void setPosition(Position position) {
        this.userFile.setPosition(position);
    }

    @Override
    public LocalDate getOnboardDate() {
        return this.userFile.getOnboardDate();
    }

    @Override
    public void setOnboardDate(LocalDate onboardDate) {
        this.userFile.setOnboardDate(onboardDate);
    }

    @Override
    public LocalDate getDepartureDate() {
        return this.userFile.getDepartureDate();
    }

    @Override
    public void setDepartureDate(LocalDate departureDate) {
        this.userFile.setDepartureDate(departureDate);
    }

    @Override
    public String getStatus() {
        return this.userFile.getStatus();
    }

    @Override
    public void setStatus(String status) {
        this.userFile.setStatus(status);
    }

    @Override
    public List<Role> getRoles() {
        return this.userFile.getRoles();
    }

    @Override
    public void setRoles(List<Role> roles) {
        this.userFile.setRoles(roles);
    }

    @Override
    public int getVacationDays() {
        return this.userFile.getVacationDays();
    }

    @Override
    public void setVacationDays(int vacationDays) {
        this.userFile.setVacationDays(vacationDays);
    }

    public static void main(String[] args) {

    }
}
