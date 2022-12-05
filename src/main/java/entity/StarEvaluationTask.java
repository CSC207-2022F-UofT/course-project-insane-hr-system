package entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class StarEvaluationTask extends CommonOrganization implements Task {
    private final CommonTask commonTask;
    private final Project project;
    private Integer results;

    public StarEvaluationTask(UUID oid, String name, Integer head, Set<Integer> members, String description,
                              LocalDateTime createTime, LocalDateTime closeTime, CommonTask commonTask, Project project) {
        super(oid, name, head, members, description, createTime, closeTime);
        this.commonTask = commonTask;
        this.project = project;
    }

    public StarEvaluationTask(UUID oid, String name, Integer head, Set<Integer> members, String description,
                              LocalDateTime createTime, CommonTask commonTask, Project project) {
        super(oid, name, head, members, description, createTime);
        this.commonTask = commonTask;
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
    public void setResults(Object results) {
        this.results = (Integer) results;
    }
}
