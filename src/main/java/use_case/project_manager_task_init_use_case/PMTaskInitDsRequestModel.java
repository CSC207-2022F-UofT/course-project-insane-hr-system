package use_case.project_manager_task_init_use_case;

import entity.task.CommonTask;

public class PMTaskInitDsRequestModel {

    private CommonTask task;

    public PMTaskInitDsRequestModel(CommonTask task) {
        this.task = task;
    }

    public CommonTask getTask() {
        return this.task;
    }
}
