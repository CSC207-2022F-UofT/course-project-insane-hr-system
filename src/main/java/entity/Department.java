package entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class Department extends CommonOrganization {

    public Department(UUID oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime, LocalDateTime closeTime) {
        super(oid, name, head, members, description, createTime, closeTime);
    }

    public Department(UUID oid, String name, Integer head, Set<Integer> members, String description, LocalDateTime createTime) {
        super(oid, name, head, members, description, createTime);
    }
}
