package use_case.unused_add_department;

import entity.Department;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class CommonDepartmentFactory implements DepartmentFactory {

    @Override
    public Department create(String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime) {
        return new Department(UUID.randomUUID(),name, head,members,description,createTime);
    }
}
