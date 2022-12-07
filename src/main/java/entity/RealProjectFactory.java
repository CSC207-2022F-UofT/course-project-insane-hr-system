package entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface RealProjectFactory {
    RealProject createOpenProject(String name, Set<Integer> members, String description, LocalDateTime createTime,
                                  Department dpt, List<Task> tasks, int funds);
    RealProject createClosedProject(String name, Set<Integer> members, String description, LocalDateTime createTime,
                                    LocalDateTime closeTime, Department dpt, List<Task> tasks, int funds);
}
