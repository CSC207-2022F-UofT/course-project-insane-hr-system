package entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class LeaveRequestTaskFactory implements TaskFactory {
    private final LeaveRequestProject project;

    public LeaveRequestTaskFactory(LeaveRequestProject project) {
        this.project = project;
    }

    @Override
    public Task createOpenTask(String name, Set<Integer> members, String description, LocalDateTime createTime) {
        return new LeaveRequestTask(UUID.randomUUID(), name, Curr.getUser().getId(), members, description, createTime,
                project);
    }

    @Override
    public Task createClosedTask(String name, Set<Integer> members, String description, LocalDateTime createTime,
                                 LocalDateTime closeTime) {
        return null;
    }
}
