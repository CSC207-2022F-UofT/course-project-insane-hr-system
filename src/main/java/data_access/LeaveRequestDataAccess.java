package data_access;

import DAO.CommonTaskDAO;
import DAO.UserDAO;
import DAO.ProjectDAO;
import DAOInterfaces.UserDAOInterface;
import DAOInterfaces.ProjectDAOInterface;
import DAOInterfaces.TaskDAOInterface;
import entity.Task;
import entity.User;
import leave_request.LeaveRequestDsGateway;
import leave_request.LeaveRequestDsRequestModel;

public class LeaveRequestDataAccess implements LeaveRequestDsGateway {
    private final ProjectDAOInterface projectDAO = new ProjectDAO();
    private final TaskDAOInterface taskDAO = new CommonTaskDAO();
    private final UserDAOInterface userDAO = new UserDAO();

    @Override
    public void save(LeaveRequestDsRequestModel requestModel) {
        projectDAO.createProject(requestModel.getProject());
        for (Task t : requestModel.getProject().getTasks()) {
            taskDAO.createTask(t);
        }
    }

    @Override
    public User getUser(Integer uid) {
        return userDAO.getUser(uid);
    }
}
