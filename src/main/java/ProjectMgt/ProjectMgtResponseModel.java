package ProjectMgt;

import entity.Project;
import entity.Task;
import entity.User;
import java.util.List;

public class ProjectMgtResponseModel {
    User ProjectManager;
    List<User> teams;
    List<Task> tasks;
    Project project;

    public ProjectMgtResponseModel(User PM, List<User> teams,
                                   List<Task> tasks, Project project) {
        this.ProjectManager = PM;
        this.tasks = tasks;
        this.teams = teams;
        this.project = project;
    }

    public User getProjectManager() {
        return ProjectManager;
    }

    public List<User> getTeams() {
        return teams;
    }

    public Project getProject() {
        return project;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
