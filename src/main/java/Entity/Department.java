package Entity;

import java.time.LocalDateTime;
import java.util.List;

public class Department extends AbstractOrganization{

    public Department(int oid, String name, int star, User head, List<Integer> members, String description, LocalDateTime creatTime, LocalDateTime closeTime) {
        super(oid, name, star, head, members, description, creatTime, closeTime);
    }

    public Department(int oid, String name, int star, User head, List<Integer> members, String description, LocalDateTime creatTime) {
        super(oid, name, star, head, members, description, creatTime);
    }
}
