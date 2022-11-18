package Entity;

import java.time.LocalDate;
import java.util.List;

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(int uid, Department dpt, String bio, String name) {
        return new CommonUser(uid, dpt, bio, name);
    }

    @Override
    public User create(int uid, Department dpt, String bio, String username, String password, List<String> roles,
                       List<Project> projects, List<Task> tasks, String position, LocalDate onboardDate) {
        UserFile userFile = new UserFile(uid, username, password, roles, projects, tasks, position, onboardDate);
        return new CommonUser(uid, dpt, bio, userFile);
    }
}
