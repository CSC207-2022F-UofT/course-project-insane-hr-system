package Entity;

import java.time.LocalDate;
import java.util.List;

public interface UserFactory {
    User create(int uid, Department dpt, String bio, String name);
    User create(int uid, Department dpt, String bio, String username, String password, List<String> roles,
                List<Project> projects, List<Task> tasks, String position, LocalDate onboardDate);
}
