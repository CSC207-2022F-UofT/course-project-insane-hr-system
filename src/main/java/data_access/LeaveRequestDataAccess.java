package data_access;

import DAO.TaskDAO;
import DAO.UserDAO;
import DAO.ProjectDAO;
import DAO.UserDAOInterface;
import DAO.ProjectDAOInterface;
import DAO.TaskDAOInterface;
import entity.task.Task;
import entity.user.User;
import use_case.leave_request.LeaveRequestDsGateway;
import use_case.leave_request.LeaveRequestDsRequestModel;

public class LeaveRequestDataAccess implements LeaveRequestDsGateway {
    private final ProjectDAOInterface projectDAO = new ProjectDAO();
    private final TaskDAOInterface taskDAO = new TaskDAO();
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
            taskDAO.createTask(t);  // save task to database
        }
    }

    /**
     * Retrieve the User from the database.
     * @param uid identifier of the user
     *
     * @return the matching User class
     */
    @Override
    public User getUser(Integer uid) {
        return userDAO.getUser(uid);
    }
}
