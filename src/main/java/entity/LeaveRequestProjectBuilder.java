package entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class LeaveRequestProjectBuilder implements ProjectBuilder {
    /**
     * This method creates an open LeaveRequestProject with request review tasks assigned to every superior.
     * @param projectName the name of the project providing the specifics of the leave request.
     * @param description the message sent by the user requesting leave.
     * @param members the superiors that needs to approve the request.
     * @param vacationDays the number of days on leave requested.
     * @param leaveType the type of leave.
     *
     * @return a new LeaveRequestProject.
     */
    @Override
    public Project createProject(String projectName, String description, Set<Integer> members, int vacationDays,
                                 LeaveType leaveType) {
        User user = Curr.getUser();
        Integer userID = user.getId();
        LocalDateTime createTime = LocalDateTime.now();

        LeaveRequestProject project = new LeaveRequestProject(UUID.randomUUID(), projectName, userID, members, description,
                createTime, vacationDays, leaveType, user.getDpt());
        user.addCurrProject(project);

        // crate a task for every member of the project
        TaskFactory taskFactory = new LeaveRequestTaskFactory(project);
        for (Integer m : members) {
            if (!m.equals(project.getHead())) {
                Set<Integer> member = new HashSet<>();
                member.add(m);
                String taskName = "Review " + projectName;
                Task task = taskFactory.createOpenTask(taskName, member, description, createTime);
                project.addTask(task);
                user.addCurrTask(task);
            }
        }

        return project;
    }
}
