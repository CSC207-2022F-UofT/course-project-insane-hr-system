package entity;

import java.time.LocalDateTime;
import java.util.*;

public class Department extends CommonOrganization {
    private LocalDateTime createTime;
    private List<UUID> projects = new ArrayList<>();
    public Department(UUID oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime, LocalDateTime closeTime) {
        super(oid, name, head, members, description, createTime, closeTime);
    }

    public Department(UUID oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime) {
        super(oid, name, head, members, description, createTime);
    }

    public Department(UUID oid, String name, String description, LocalDateTime createTime) {
        super(oid, name, new HashSet<>(), description);
        this.createTime = createTime;

    }

    public boolean addProject(Project project) {
        return this.projects.add(project.getOid());
    }

    public boolean addProject(UUID projectID) {
        return this.projects.add(projectID);
    }

    public List<UUID> getProjects() {
        return projects;
    }

    public void setProjects(List<UUID> projects) {
        this.projects = projects;
    }
}
