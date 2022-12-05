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

    /**
     * Save the created leave request project and tasks to the database.
     * @param requestModel to store
     *
     */
    @Override
    public void save(LeaveRequestDsRequestModel requestModel) {
        projectDAO.createProject(requestModel.getProject());
        for (Task t : requestModel.getProject().getTasks()) {
            taskDAO.createTask(t);
        }
    }

    /**
     * Retrieve the User class from the database.
     * @param uid identifier of the user
     *
     * @return the matching User class
     */
    @Override
    public User getUser(Integer uid) {
        return userDAO.getUser(uid);
    }
}
