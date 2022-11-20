package project_manager_task_init_use_case;

public class PMTaskInitInteractor implements PMTaskInitInputBoundary{

    final PMTaskInitOutputBoundary presenter;

    public PMTaskInitInteractor(PMTaskInitOutputBoundary presenter) {
        this.presenter = presenter;
    }

    public PMTaskInitResponseModel createTask(PMTaskInitRequestModel requestModel) {

        return null;
    }
}
