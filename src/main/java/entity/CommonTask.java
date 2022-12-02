package entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class CommonTask extends CommonOrganization implements Task {
    private final CommonProject commonProject;
    private Object results;
    private Integer star;

    // construct CLOSED task
    public CommonTask(UUID oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime, LocalDateTime closeTime, CommonProject commonProject, int star) {
        super(oid, name, head, members, description, createTime, closeTime);
        this.commonProject = commonProject;
        this.results = results;
        this.star = star;
    }
    // construct OPEN task
    public CommonTask(UUID oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime, CommonProject commonProject) {
        super(oid, name, head, members, description, createTime);
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

    public String getType(){
        return "COMMON";
    }
}
