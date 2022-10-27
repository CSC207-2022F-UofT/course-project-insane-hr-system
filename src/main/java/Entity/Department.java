package Entity;

import java.util.List;

public class Department extends AbstractOrganization{
    public Department(String name,
                      int star,
                      User head,
                      List<User> members,
                      String creatTime,
                      String closeTime,
                      String description) {
        super(name, star, head, members, creatTime, closeTime, description);
    }
}
