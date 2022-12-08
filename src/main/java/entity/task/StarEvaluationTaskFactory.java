package entity.task;

import entity.Curr;
import entity.Organization;
import entity.project.Project;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class StarEvaluationTaskFactory implements TaskFactory {
    private final Project project;
    private final Organization organization;

    public StarEvaluationTaskFactory(Project project, Organization organization) {
        this.project = project;
        this.organization = organization;
    }

    @Override
    public Task createOpenTask(String name, Set<Integer> members, String description, LocalDateTime createTime) {
        return new StarEvaluationTask(UUID.randomUUID(), name, Curr.getUser().getId(), members, description, createTime,
                organization, project);
    }

    @Override
    public Task createClosedTask(String name, Set<Integer> members, String description, LocalDateTime createTime,
                                 LocalDateTime closeTime) {
        return new StarEvaluationTask(UUID.randomUUID(), name, Curr.getUser().getId(), members, description, createTime,
                closeTime, organization, project);
    }
}
