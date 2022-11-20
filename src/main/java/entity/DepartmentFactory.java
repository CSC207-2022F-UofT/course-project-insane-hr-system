package entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public interface DepartmentFactory{

    Department create(String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime);
}
