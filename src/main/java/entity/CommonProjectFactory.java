package entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CommonProjectFactory implements RealProjectFactory {

    @Override
    public RealProject createOpenProject(String name, Set<Integer> members, String description,
                                         LocalDateTime createTime, Department dpt, List<Task> tasks, int funds) {
        return new CommonProject(UUID.randomUUID(), name, Curr.getUser().getId(), members, description, createTime,
                dpt, tasks, funds);
    }

    @Override
    public RealProject createClosedProject(String name, int star, Set<Integer> members, String description,
                                           LocalDateTime createTime, LocalDateTime closeTime, Department dpt,
                                           List<Task> tasks, int funds) {
        return new CommonProject(UUID.randomUUID(), name, star, Curr.getUser().getId(), members, description, createTime,
                closeTime, dpt, tasks, funds);
    }
}
