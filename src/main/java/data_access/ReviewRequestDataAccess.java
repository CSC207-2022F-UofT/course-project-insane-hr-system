package data_access;

import DAO.TaskDAO;
import DAO.UserDAO;
import DAO.ProjectDAO;
import DAO.UserDAOInterface;
import DAO.ProjectDAOInterface;
import DAO.TaskDAOInterface;
import entity.project.LeaveRequestProject;
import entity.project.LeaveType;
import entity.task.Task;
import entity.user.User;
import use_case.review_request.ReviewRequestDsGateway;
import use_case.review_request.ReviewRequestDsRequestModel;

import java.util.UUID;

public class ReviewRequestDataAccess implements ReviewRequestDsGateway {
    private final TaskDAOInterface taskDAO = new TaskDAO();
    private final ProjectDAOInterface projectDAO = new ProjectDAO();
    private final UserDAOInterface userDAO = new UserDAO();

    /**
     * Update the leave request project, task, and related users in the database.
     * @param requestModel to update
     *
     */
    @Override
    public void updateRequest(ReviewRequestDsRequestModel requestModel) {
        taskDAO.updateTask(requestModel.getTask());

        LeaveRequestProject project = (LeaveRequestProject) requestModel.getProject();
        projectDAO.updateProject(project);
        if (!requestModel.getStatus().isEmpty()) {
            User user = userDAO.getUser(project.getHead());
            user.setStatus(requestModel.getStatus());
            if (project.getLeaveType() == LeaveType.VACATION) {
                user.setVacationDays(user.getVacationDays() - project.getVacationDays());
            }
            userDAO.updateUser(user);
            user.removeCurrProject(project);
            user.removeCurrTask(requestModel.getTask());
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
