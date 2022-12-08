package data_access;

import DAO.ProjectDAO;
import DAO.TaskDAO;
import DAO.UserDAO;
import DAOInterfaces.ProjectDAOInterface;
import DAOInterfaces.TaskDAOInterface;
import DAOInterfaces.UserDAOInterface;
import complete_task.CompleteTaskDsGateway;
import complete_task.CompleteTaskDsRequestModel;
import entity.Task;

import java.util.UUID;

public class CompleteTaskDataAccess implements CompleteTaskDsGateway {
    private final TaskDAOInterface taskDAO = new TaskDAO();
    private final UserDAOInterface userDAO = new UserDAO();
    private final ProjectDAOInterface projectDAO = new ProjectDAO();



    @Override
    public void save(CompleteTaskDsRequestModel requestModel) {
        requestModel.getTask().setState("CLOSED");
    }

    @Override
    public Task getTask(UUID oid) {
        return taskDAO.getTask(oid);
    }
}
