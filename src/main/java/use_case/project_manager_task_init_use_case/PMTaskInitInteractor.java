package use_case.project_manager_task_init_use_case;

import entity.*;
import entity.project.CommonProject;
import entity.project.Project;
import entity.task.CommonTask;
import entity.task.CommonTaskFactory;
import entity.task.Task;
import entity.task.TaskFactory;

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

    /**
     *This method creates a new task from the request model, and saves it in the database, then returns the response
     * model that gets passed to the presenter.
     *
     * @param requestModel the request model created from user input
     * @return the response model that gets passed to the presenter
     */

    public PMTaskInitResponseModel createTask(PMTaskInitRequestModel requestModel) {

        Set<Integer> members = new HashSet<>();
        members.add(requestModel.getEmployeeId());
        LocalDateTime createTime = LocalDateTime.now();
        Task task = commonTaskFactory.createOpenTask(requestModel.getTaskName(), members, requestModel.getTaskDescription(), createTime);

        PMTaskInitDsRequestModel dsRequestModel = new PMTaskInitDsRequestModel((CommonTask) task);
        taskInitGateway.saveTask(dsRequestModel);

        PMTaskInitResponseModel responseModel = new PMTaskInitResponseModel(requestModel.getTaskName(), requestModel.getTaskDescription(), requestModel.getEmployeeId());
        return presenter.prepareSuccessView(responseModel);
    }
}
