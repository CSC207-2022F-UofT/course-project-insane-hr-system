package add_remove_employee_to_project;

import entity.Project;
import entity.Task;

public class EmployeeToProjectInteractor implements EmployeeToProjectInputBoundary {

    public EmployeeToProjectResponseModel create(EmployeeToProjectRequestModel requestModel) {

        // import data
        Project project = requestModel.getProject();
        Integer toDo = requestModel.getToDo();
        boolean toAdd = requestModel.getToAdd();
        boolean succeed = false;

        // add or remove employee from project
        if (toAdd) {
            succeed = project.addMember(toDo);
        } else {
            succeed = project.removeMember(toDo);
        }

        // return response model
        return new EmployeeToProjectResponseModel(project, succeed);
    }

}
