package entity;

import java.time.LocalDate;
import java.util.List;

public interface UserFactory {
    User create(int uid, Department dpt, String bio, String name);
    User create(int uid, Department dpt, String bio, String username, String password, List<String> roles,
                List<Project> projects, List<Task> tasks, Position position, LocalDate onboardDate);
    User createUserInPeriod(User user, LocalDate startDate, LocalDate endDate);
}
