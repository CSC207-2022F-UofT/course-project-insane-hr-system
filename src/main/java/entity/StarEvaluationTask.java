package entity;

import jdk.jshell.spi.ExecutionControl;

import java.time.LocalDateTime;
import java.util.Set;

public class StarEvaluationTask extends CommonOrganization implements Task {
    private final Organization evaluatedOrganization;
    private final Project project;
    private Integer results;

    public StarEvaluationTask(int oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime creatTime, LocalDateTime closeTime, Organization evaluatedOrganization, Project project) {
        super(oid, name, head, members, description, creatTime, closeTime);
        this.evaluatedOrganization = evaluatedOrganization;
        this.project = project;
    }

    public StarEvaluationTask(int oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime creatTime, Organization evaluatedOrganization, Project project) {
        super(oid, name, head, members, description, creatTime);
        this.evaluatedOrganization = evaluatedOrganization;
        this.project = project;
    }


    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public Object getResults() {
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
