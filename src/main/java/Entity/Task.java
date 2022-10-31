package Entity;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Task extends AbstractOrganization{
    private final Project project;
    private Object results;

    // construct CLOSED task
    public Task(int oid, String name, int star, User head, List<Integer> members, String description, LocalDateTime creatTime, LocalDateTime closeTime, Project project,
                Object results) {
        super(oid, name, star, head, members, description, creatTime, closeTime);
        this.project = project;
        this.results = results;
    }
    // construct OPEN task
    public Task(int oid, String name, int star, User head, List<Integer> members, String description, LocalDateTime creatTime, Project project) {
        super(oid, name, star, head, members, description, creatTime);
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }
}
