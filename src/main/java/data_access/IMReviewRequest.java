package data_access;

import entity.*;
import review_request.ReviewRequestDsGateway;
import review_request.ReviewRequestDsRequestModel;

import java.util.Map;
import java.util.UUID;

public class IMReviewRequest implements ReviewRequestDsGateway {
    final Map<UUID, Task> tasks;
    final Map<Integer, User> users;

    public IMReviewRequest(Map<UUID, Task> tasks, Map<Integer, User> users) {
        this.tasks = tasks;
        this.users = users;
    }

    @Override
    public void updateRequest(ReviewRequestDsRequestModel requestModel) {
        // DAO not needed as it is in memory
        Task task = requestModel.getTask();
        for (Integer m : task.getMembers()) {
            User member = users.get(m);
            member.removeCurrTask(task);
        }

        LeaveRequestProject project = (LeaveRequestProject) requestModel.getProject();
        if (!requestModel.getStatus().isEmpty()) {
            User user = users.get(project.getHead());
            user.setStatus(requestModel.getStatus());
            if (project.getLeaveType() == LeaveType.VACATION) {
                user.setVacationDays(user.getVacationDays() - project.getVacationDays());
            }
        }
    }

    @Override
    public Task getTask(UUID oid) {
        return tasks.get(oid);
    }
}
