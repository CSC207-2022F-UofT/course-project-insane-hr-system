package data_access;

import DAO.TaskDAO;
import DAO.TaskDAOInterface;
import DAO.UserDAO;
import DAO.UserDAOInterface;
import use_case.evaluate_task.EvaluateTaskDsGateway;
import use_case.evaluate_task.EvaluateTaskRequestModel;

import java.util.UUID;

public class EvaluateTaskDataAccess implements EvaluateTaskDsGateway {
    private final TaskDAOInterface taskDAO = new TaskDAO();
    private final UserDAOInterface userDAO = new UserDAO();


    @Override
    public void save(EvaluateTaskRequestModel requestModel) {

    }

    @Override
    public Integer getStar(UUID oid) {
        return (Integer) taskDAO.getTask(oid).getResults();
    }
}
