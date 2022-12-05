package data_access;

import DAO.CommonTaskDAO;
import DAOInterfaces.TaskDAOInterface;
import project_manager_task_init_use_case.PMTaskInitDsRequestModel;
import project_manager_task_init_use_case.PMTaskInitGateway;
import project_manager_task_init_use_case.PMTaskInitInteractor;

public class PMTaskInitDataAccess implements PMTaskInitGateway {



    public PMTaskInitDataAccess() {

    }

    @Override
    public void saveTask(PMTaskInitDsRequestModel requestModel) {
        //CommonTaskDAO.saveTask(requestModel.getTask());
        //above line will work if the method in the CommonTaskDAO class is static
    }
}
