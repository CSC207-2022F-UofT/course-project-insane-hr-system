package presenter;

import use_case.project_manager_task_init_use_case.PMTaskInitOutputBoundary;
import use_case.project_manager_task_init_use_case.PMTaskInitResponseModel;

public class PMTaskInitPresenter implements PMTaskInitOutputBoundary {

    @Override
    public PMTaskInitResponseModel prepareSuccessView(PMTaskInitResponseModel response) {
        return response;
    }
}
