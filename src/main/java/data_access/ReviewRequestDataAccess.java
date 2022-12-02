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

import static entity.Constants.CLOSED;

public class ReviewRequestDataAccess implements ReviewRequestDsGateway {
    private final TaskDAOInterface taskDAO = new CommonTaskDAO();
    private final ProjectDAOInterface projectDAO = new ProjectDAO();
    private final UserDAOInterface userDAO = new UserDAO();

    @Override
    public void updateRequest(ReviewRequestDsRequestModel requestModel) {
        taskDAO.updateTask(requestModel.getTask());
        LeaveRequestProject project = (LeaveRequestProject) requestModel.getProject();
        if (requestModel.getStatus().equals(CLOSED)) {
            projectDAO.updateProject(project);
            if (project.getLeaveType() == LeaveType.VACATION) {
                User user = userDAO.getUser(requestModel.getTask().getHead());
                user.setVacationDays(user.getVacationDays() - project.getVacationDays());
                userDAO.updateUser(user);
            }
        }
    }

    @Override
    public Task getTask(UUID oid) {
        return taskDAO.getTask(oid);
    }
}
