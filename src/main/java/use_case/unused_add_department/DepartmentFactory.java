package use_case.unused_add_department;

import entity.Department;

import java.time.LocalDateTime;
import java.util.Set;

public interface DepartmentFactory{

    Department create(String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime);
}
