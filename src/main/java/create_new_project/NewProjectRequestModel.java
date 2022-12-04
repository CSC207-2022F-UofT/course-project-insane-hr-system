package create_new_project;

import entity.Department;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class NewProjectRequestModel {
    Integer ProjectManagerID;
    Set<Integer> teams;
    Integer funds;
    String name;
    String description;
    LocalDateTime createTime;
    Department dpt;
    LocalDateTime closeTime;
    Boolean finished;

    public Integer getProjectManagerID() {
        return ProjectManagerID;
    }

    public Set<Integer> getTeams() {
        return teams;
    }

    public Integer getFunds() {
        return funds;
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

    public Department getDpt() {
        return dpt;
    }
}
