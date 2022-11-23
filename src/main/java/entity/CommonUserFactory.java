package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(int uid, Department dpt, String bio, String name) {
        return new CommonUser(uid, dpt, bio, name);
    }

    @Override
    public User create(int uid, Department dpt, String bio, String username, String password, List<Role> roles,
                       List<Project> projects, List<Task> tasks, Position position, LocalDate onboardDate) {
        UserFile userFile = new UserFile(uid, username, password, roles, projects, tasks, position, onboardDate);
        return new CommonUser(uid, dpt, bio, userFile);
    }

    @Override
    public User createUserInPeriod(User user, LocalDate startDate, LocalDate endDate) {
        List<Project> projectsInPeriod = new ArrayList<>();
        List<Task> tasksInPeriod = new ArrayList<>();

        for (Project project : user.getProjects()) {
            if (project.getCloseTime().isAfter(startDate.atStartOfDay()) && project.getCloseTime().isBefore(endDate.atStartOfDay())) {
                projectsInPeriod.add(project);
            }
        }

        for (Task task : user.getTasks()) {
            if (task.getCloseTime().isAfter(startDate.atStartOfDay()) && task.getCloseTime().isBefore(endDate.atStartOfDay())) {
                tasksInPeriod.add(task);
            }
        }
        UserFile userFile = new UserFile(user.getId(), user.getUsername(), user.getPassword(), user.getRoles(),
                projectsInPeriod, tasksInPeriod,
                user.getPosition(), user.getOnboardDate());
        return new CommonUser(user.getId(), user.getDpt(), user.getBio(), userFile);
    }
}
