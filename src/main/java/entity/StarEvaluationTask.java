package entity;

import jdk.jshell.spi.ExecutionControl;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class StarEvaluationTask extends CommonOrganization implements Task {
    private final Organization evaluatedOrganization;
    private final Project project;
    private Integer results;

    public StarEvaluationTask(UUID oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime, LocalDateTime closeTime, Organization evaluatedOrganization, Project project) {
        super(oid, name, head, members, description, createTime, closeTime);
        this.evaluatedOrganization = evaluatedOrganization;
        this.project = project;
    }

    public StarEvaluationTask(UUID oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime, Organization evaluatedOrganization, Project project) {
        super(oid, name, head, members, description, createTime);
        this.evaluatedOrganization = evaluatedOrganization;
        this.project = project;
    }


    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public Integer getResults() {
        return results;
    }

    @Override
    public void setResults(Object results) throws ExecutionControl.NotImplementedException {
        if (results instanceof Integer) {
            this.results = ((Integer) results);
        }else {
            throw new ExecutionControl.NotImplementedException("Input should be Integer");
        }
    }
}
