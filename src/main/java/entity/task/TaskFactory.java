package entity.task;

import java.time.LocalDateTime;
import java.util.Set;

public interface TaskFactory {
    Task createOpenTask(String name, Set<Integer> members, String description, LocalDateTime createTime);

    Task createClosedTask(String name, Set<Integer> members, String description, LocalDateTime createTime,
                          LocalDateTime closeTime);
}
