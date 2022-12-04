package add_remove_task_to_project;

import entity.Project;
import entity.Task;
public class TaskToProjectInteractor implements TaskToProjectInputBoundary {

    @Override
    public TaskToProjectResponseModel create(TaskToProjectRequestModel requestModel) {

        // import data
        Project project = requestModel.getProject();
        Task toDo = requestModel.getToDo();
        boolean toAdd = requestModel.getToAdd();
        boolean succeed = false;

        // add or remove task from project
        if (toAdd) {
            succeed = project.addTask(toDo);
        } else {
            succeed = project.removeTask(toDo);
        }

        // return response model
        return new TaskToProjectResponseModel(project, succeed);
    }
}
