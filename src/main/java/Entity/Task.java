package Entity;

import java.util.List;

public abstract class Task extends AbstractOrganization{
    private final Project project;
    private Object results;

    public Task(String name,
                int star,
                User head,
                List<User> members,
                String creatTime,
                String closeTime,
                String description,
                Project project) {
        super(name, star, head, members, creatTime, closeTime, description);
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
