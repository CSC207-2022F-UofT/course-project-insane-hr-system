package entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class LeaveRequestProjectBuilder implements ProjectBuilder {
    @Override
    public Project createProject(String projectName, String description, Set<Integer> members) {
        User user = Curr.getUser();
        Integer userId = user.getId();
        LocalDateTime createTime = LocalDateTime.now();

        LeaveRequestProject project = new LeaveRequestProject(UUID.randomUUID(), projectName, userId, members, description,
                createTime);
        user.addCurrProject(project);

        // crate a task for every member of the project
        TaskFactory taskFactory = new LeaveRequestTaskFactory(project);
        for (Integer m : members) {
            Set<Integer> member = new HashSet<>();
            member.add(m);
            String taskName = "Review " + projectName;
            Task task = taskFactory.createOpenTask(taskName, member, description, createTime);
            project.addTask(task);
        }

        return project;
    }
}
