package ProjectMgt;

import entity.Task;
import entity.User;
import java.util.List;

public class ProjectMgtRequestModel {
    User ProjectManager;
    Task toAdd;
    List<User> teams;
    Task toRemove;

    public ProjectMgtRequestModel(User PM,Task toAdd, List<User> team, Task toRemove) {
        this.toRemove = toRemove;
        this.teams = team;
        this.toAdd = toAdd;
        this.ProjectManager = PM;
    }

    public User getProjectManager() {
        return ProjectManager;
    }

    public Task getToRemove() {
        return toRemove;
    }

    public List<User> getTeams() {
        return teams;
    }

    public Task getToAdd() {
        return toAdd;
    }
}
