package project_manager_task_init_use_case;

import entity.CommonTask;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class PMTaskInitDsRequestModel {

    private CommonTask task;

    public PMTaskInitDsRequestModel(CommonTask task) {
        this.task = task;
    }

    public CommonTask getTask() {
        return this.task;
    }
}
