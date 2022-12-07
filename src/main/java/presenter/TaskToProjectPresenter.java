package presenter;

import add_remove_task_to_project.TaskToProjectOutputBoundary;
import add_remove_task_to_project.TaskToProjectResponseModel;

public class TaskToProjectPresenter implements TaskToProjectOutputBoundary {
    @Override
    public TaskToProjectResponseModel prepareTaskEdit(TaskToProjectResponseModel responseModel) {
        return responseModel;
    }
}
