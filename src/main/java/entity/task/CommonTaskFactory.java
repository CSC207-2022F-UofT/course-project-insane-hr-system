package entity.task;

import entity.Curr;
import entity.project.CommonProject;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class CommonTaskFactory implements TaskFactory{
    private final CommonProject project;
    private Integer star;

    public CommonTaskFactory(CommonProject project) {
        this.project = project;
    }

    public CommonTaskFactory(CommonProject project, Integer star) {
        this.project = project;
        this.star = star;
    }

    @Override
    public Task createOpenTask(String name, Set<Integer> members, String description, LocalDateTime createTime) {
        return new CommonTask(UUID.randomUUID(), name, Curr.getUser().getId(), members, description, createTime, project);
    }

    @Override
    public Task createClosedTask(String name, Set<Integer> members, String description, LocalDateTime createTime,
                                 LocalDateTime closeTime) {
        return new CommonTask(UUID.randomUUID(), name, Curr.getUser().getId(), members, description, createTime, closeTime,
                project, star);
    }
}
