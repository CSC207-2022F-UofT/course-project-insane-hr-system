package entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class LeaveRequestProjectBuilder implements ProjectBuilder {
    @Override
    public Project createProject(String projectName, String description) {
        User user = Curr.getUser();
        Integer userId = user.getId();
        LocalDateTime createTime = LocalDateTime.now();

        // retrieve all managers of user
        Set<Integer> members = new HashSet<>();
        for (Project p : user.getProjects()) {
            Integer head = p.getHead();
            if (!head.equals(userId)) {
                members.add(head);
            }
        }

        LeaveRequestProject project = new LeaveRequestProject(UUID.randomUUID(), projectName, userId, members, description,
                createTime);

        // crate a task for every member of the project
        for (Integer m : members) {
            Set<Integer> member = new HashSet<>();
            member.add(m);
            String taskName = "Review " + projectName;
            Task task = new LeaveRequestTask(UUID.randomUUID(), taskName, userId, member, description, createTime, project);
            project.addTask(task);
        }

        return project;
    }
}
