package create_new_project;

import entity.Department;
import entity.Project;
import entity.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class NewProjectResponseModel {
    UUID oid;
    Integer ProjectManagerID;
    Set<Integer> teams;
    List<Task> tasks;
    Integer funds;
    String name;
    String description;
    LocalDateTime createTime;
    Department dpt;
    LocalDateTime closeTime;
    Boolean finished;
    Project project;

    public NewProjectResponseModel(Integer PM, Set<Integer> teams, List<Task> tasks,
                                   Integer funds, String name, String description,
                                   LocalDateTime createTime, Department dpt,
                                   LocalDateTime closeTime, Boolean finished,
                                   Project project) {
        this.ProjectManagerID = PM;
        this.tasks = tasks;
        this.teams = teams;
        this.funds = funds;
        this.name = name;
        this.description = description;
        this.createTime = createTime;
        this.dpt = dpt;
        this.closeTime = closeTime;
        this.project = project;
    }

    public Integer getProjectManagerID() {
        return ProjectManagerID;
    }

    public Set<Integer> getTeams() {
        return teams;
    }

    public Project getProject() {
        return project;
    }

    public UUID getOid() {
        return oid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getFinished() {
        return finished;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Integer getFunds() {
        return funds;
    }

    public Department getDpt() {
        return dpt;
    }
}
