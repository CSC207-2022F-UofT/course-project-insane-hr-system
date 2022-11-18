package entity;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class BooleanEvaluationTask extends CommonOrganization implements Task {
    private final Task evaluatedTask;
    private final Project project;
    private Boolean results;

    public BooleanEvaluationTask(int oid, String name, Integer head, Set<UUID> members, String description, LocalDateTime creatTime, LocalDateTime closeTime, Task evaluatedTask, Project project) {
        super(oid, name, head, members, description, creatTime, closeTime);
        this.evaluatedTask = evaluatedTask;
        this.project = project;
    }

    public BooleanEvaluationTask(int oid, String name, Integer head, Set<UUID> members, String description, LocalDateTime creatTime, Task evaluatedTask, Project project) {
        super(oid, name, head, members, description, creatTime);
        this.evaluatedTask = evaluatedTask;
        this.project = project;
    }


    public Task getEvaluatedTask() {
        return evaluatedTask;
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
    public void setResults(Object results) throws NotImplementedException {
        if (results instanceof Boolean) {
            this.results = ((Boolean) results);
        }else {
            throw new NotImplementedException("Input should be Boolean");
        }
    }

}
