package project_manager_task_init_use_case;

import entity.CommonTask;
import entity.CommonTaskFactory;
import entity.CommonTaskFactoryInterface;

public class PMTaskInitInteractor implements PMTaskInitInputBoundary{

    final PMTaskInitOutputBoundary presenter;

    final CommonTaskFactoryInterface commonTaskFactory;

    final PMTaskInitGateway taskInitGateway;

    public PMTaskInitInteractor(PMTaskInitOutputBoundary presenter, CommonTaskFactoryInterface commonTaskFactory, PMTaskInitGateway gateway) {
        this.presenter = presenter;
        this.commonTaskFactory = commonTaskFactory;
        this.taskInitGateway = gateway;
    }

    public PMTaskInitResponseModel createTask(PMTaskInitRequestModel requestModel) {

        CommonTask task = commonTaskFactory.createTask(requestModel.getTaskName(), requestModel.getTaskDescription(), requestModel.getEmployee(), requestModel.getProject());
        taskInitGateway.save(requestModel);

        //TODO: return response model
        return null;
    }
}
