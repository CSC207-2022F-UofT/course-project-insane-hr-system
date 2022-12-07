package entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class LeaveRequestTaskFactory implements TaskFactory {
    private final LeaveRequestProject project;

    public LeaveRequestTaskFactory(LeaveRequestProject project) {
        this.project = project;
    }

    /**
     * This method creates an open LeaveRequestTask assigned to the attribute project.
     * @param name the name of the task providing the specifics of the leave request.
     * @param members the members assigned to the task.
     * @param description the message sent by the user requesting leave.
     * @param createTime the time the task was created.
     *
     * @return a new LeaveRequestTask.
     */
    @Override
    public Task createOpenTask(String name, Set<Integer> members, String description, LocalDateTime createTime) {
        return new LeaveRequestTask(UUID.randomUUID(), name, Curr.getUser().getId(), members, description, createTime,
                project);
    }

    @Override
    public Task createClosedTask(String name, Set<Integer> members, String description, LocalDateTime createTime,
                                 LocalDateTime closeTime) {
        return new LeaveRequestTask(UUID.randomUUID(), name, Curr.getUser().getId(), members, description, createTime,
                closeTime, project);
    }
}
