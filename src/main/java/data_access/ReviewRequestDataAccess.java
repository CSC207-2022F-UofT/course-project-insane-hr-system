package data_access;

import DAO.CommonTaskDAO;
import DAO.UserDAO;
import DAO.ProjectDAO;
import DAOInterfaces.UserDAOInterface;
import DAOInterfaces.ProjectDAOInterface;
import DAOInterfaces.TaskDAOInterface;
import entity.*;
import review_request.ReviewRequestDsGateway;
import review_request.ReviewRequestDsRequestModel;

import java.util.UUID;

public class ReviewRequestDataAccess implements ReviewRequestDsGateway {
    private final TaskDAOInterface taskDAO = new CommonTaskDAO();
    private final ProjectDAOInterface projectDAO = new ProjectDAO();
    private final UserDAOInterface userDAO = new UserDAO();

    /**
     * Update the leave request project, task, and related users in the database.
     * @param requestModel to update
     *
     */
    @Override
    public void updateRequest(ReviewRequestDsRequestModel requestModel) {
        Task task = requestModel.getTask();
        taskDAO.updateTask(task);
        for (Integer m : task.getMembers()) {
            User member = userDAO.getUser(m);
            member.removeCurrTask(task);
            userDAO.updateUser(member);
        }

        LeaveRequestProject project = (LeaveRequestProject) requestModel.getProject();
        projectDAO.updateProject(project);
        if (!requestModel.getStatus().isEmpty()) {
            User user = userDAO.getUser(project.getHead());
            user.setStatus(requestModel.getStatus());
            if (project.getLeaveType() == LeaveType.VACATION) {
                user.setVacationDays(user.getVacationDays() - project.getVacationDays());
            }
            userDAO.updateUser(user);
        }
    }

    /**
     * Retrieve the Task from the database.
     * @param oid identifier of the task
     *
     * @return the matching Task class
     */
    @Override
    public Task getTask(UUID oid) {
        return taskDAO.getTask(oid);
    }
}
