package entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface UserFactory {
    User create(UUID uid, Department dpt, String bio, String name);
    User create(UUID uid, Department dpt, String bio, String username, String password, List<String> roles,
                List<Project> projects, List<Task> tasks, String position, LocalDate onboardDate);
}
