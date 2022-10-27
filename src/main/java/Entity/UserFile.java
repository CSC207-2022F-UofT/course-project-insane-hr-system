package Entity;

import java.util.List;

public class UserFile {
    private final int id;
    private String username;
    private String password;
    private List<Project> currProjects;
    private List<Task> currTasks;
    private String position;


    public UserFile(int id,
                    String username,
                    String password,
                    List<Project> currProjects,
                    List<Task> currTasks,
                    String position) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.currProjects = currProjects;
        this.currTasks = currTasks;
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("%s's File:\n ID: %d\n Position: %s\n Current Project: %s\n Current Tasks: %s\n ",
                this.username, this.id, this.position, this.currProjects.toString(), this.currTasks.toString());
    }

    public String getName() {
        return this.username;
    }

    // CurrProjects and CurrTasks adding and removing
    public void addCurrProject(Project project) {
        this.currProjects.add(project);
    }

    public void addCurrTask(Task task) {
        this.currTasks.add(task);
    }

    public boolean removeCurrTask(String taskName) {
        for (Task task : this.currTasks) {
            if (taskName.equals(task.name)) {
                this.currTasks.remove(task);
                return true;
            }
        }
        return false;
    }

    public boolean removeCurrProject(String projectName) {
        for (Project project : this.currProjects) {
            if (projectName.equals(project.name)) {
                this.currProjects.remove(project);
                return true;
            }
        }
        return false;
    }

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

    public List<Project> getCurrProjects() {
        return currProjects;
    }

    public void setCurrProjects(List<Project> currProjects) {
        this.currProjects = currProjects;
    }

    public List<Task> getCurrTasks() {
        return currTasks;
    }

    public void setCurrTasks(List<Task> currTasks) {
        this.currTasks = currTasks;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
