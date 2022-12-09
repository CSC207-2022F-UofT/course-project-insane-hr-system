package data_access;


import DAO.*;

import entity.task.CommonTask;
import entity.task.Task;
import presenter.view_model.Table;
import use_case.complete_task.CompleteTaskDsGateway;
import use_case.complete_task.CompleteTaskDsRequestModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompleteTaskDataAccess implements CompleteTaskDsGateway {
    private final TaskDAOInterface taskDAO = new TaskDAO();
    private final UserDAOInterface userDAO = new UserDAO();
    private final ProjectDAOInterface projectDAO = new ProjectDAO();



    @Override
    public void save(CompleteTaskDsRequestModel requestModel) {
        Task task = requestModel.getTask();
        task.setState("CLOSED");
        task.setCloseTime(LocalDateTime.now());
        taskDAO.updateTask(task);
    }

    @Override
    public Task getTask(UUID oid) {
        return taskDAO.getTask(oid);
    }
}
