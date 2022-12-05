package project_manager_task_init_use_case;

import entity.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class PMTaskInitInteractor implements PMTaskInitInputBoundary{

    final PMTaskInitOutputBoundary presenter;

    TaskFactory commonTaskFactory;

    final PMTaskInitGateway taskInitGateway;



    public PMTaskInitInteractor(PMTaskInitOutputBoundary presenter, PMTaskInitGateway gateway) {
        this.presenter = presenter;
        for (Project subproject : Curr.getUser().getProjects()) {
            if (subproject.getHead() == Curr.getUser().getId()){
                this.commonTaskFactory = new CommonTaskFactory((CommonProject)subproject);
            }
        }
        this.taskInitGateway = gateway;
    }

    public PMTaskInitResponseModel createTask(PMTaskInitRequestModel requestModel) {

        Set<Integer> members = new HashSet<>();
        members.add(requestModel.getEmployeeId());
        LocalDateTime createTime = LocalDateTime.now();
        Task task = commonTaskFactory.createOpenTask(requestModel.getTaskName(), members, requestModel.getTaskDescription(), createTime);

        PMTaskInitDsRequestModel dsRequestModel = new PMTaskInitDsRequestModel(task.getOid(), task.getName(), task.getHead(), task.getMembers(), task.getDescription(), task.getCreateTime());
        taskInitGateway.saveTask(dsRequestModel);

        PMTaskInitResponseModel responseModel = new PMTaskInitResponseModel(requestModel.getTaskName(), requestModel.getTaskDescription(), requestModel.getEmployeeId());
        return presenter.prepareSuccessView(responseModel);
    }
}