package add_remove_task_to_project;

public interface TaskToProjectInputBoundary {
    TaskToProjectResponseModel create(TaskToProjectRequestModel requestModel);
}
