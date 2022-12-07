package data_access;

import entity.Project;
import entity.Task;
import entity.User;
import leave_request.LeaveRequestDsGateway;
import leave_request.LeaveRequestDsRequestModel;

import java.util.Map;
import java.util.UUID;

public class IMLeaveRequest implements LeaveRequestDsGateway {
    final Map<Integer, User> users;
    final Map<UUID, Project> projects;
    final Map<UUID, Task> tasks;

    public IMLeaveRequest(Map<Integer, User> users, Map<UUID, Project> projects, Map<UUID, Task> tasks) {
        this.users = users;
        this.projects = projects;
        this.tasks = tasks;
    }

    @Override
    public void save(LeaveRequestDsRequestModel requestModel) {
        Project project = requestModel.getProject();
        projects.put(project.getOid(), project);
        for (Task t : project.getTasks()) {
            tasks.put(t.getOid(), t);
            Integer m = t.getMembers().iterator().next();
            getUser(m).addCurrTask(t);
            getUser(m).addCurrProject(project);
        }
    }

    @Override
    public User getUser(Integer uid) {
        return users.get(uid);
    }
}
