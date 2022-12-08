package data_access;


import DAO.*;

import entity.task.Task;
import use_case.complete_task.CompleteTaskDsGateway;
import use_case.complete_task.CompleteTaskDsRequestModel;

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
