package entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class Department extends CommonOrganization {

    public Department(int oid, String name, Integer head, Set<UUID> members, String description, LocalDateTime creatTime, LocalDateTime closeTime) {
        super(oid, name, head, members, description, creatTime, closeTime);
    }

    public Department(int oid, String name, Integer head, Set<UUID> members, String description, LocalDateTime creatTime) {
        super(oid, name, head, members, description, creatTime);
    }
}
