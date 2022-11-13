package Entity;

import java.time.LocalDateTime;
import java.util.Set;

public abstract class CommonTask extends CommonOrganization implements Task {
    private final CommonProject commonProject;
    private Object results;
    private Integer star;

    // construct CLOSED task
    public CommonTask(int oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime creatTime, LocalDateTime closeTime, CommonProject commonProject,
                      Object results, int star) {
        super(oid, name, head, members, description, creatTime, closeTime);
        this.commonProject = commonProject;
        this.results = results;
        this.star = star;
    }
    // construct OPEN task
    public CommonTask(int oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime creatTime, CommonProject commonProject) {
        super(oid, name, head, members, description, creatTime);
        this.commonProject = commonProject;
    }

    @Override
    public Project getProject() {
        return commonProject;
    }

    @Override
    public Object getResults() {
        return results;
    }

    @Override
    public void setResults(Object results) {
        this.results = results;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
