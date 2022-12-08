package add_remove_employee_to_project;

import entity.Project;

public class EmployeeToProjectInteractor implements EmployeeToProjectInputBoundary {

    @Override
    public EmployeeToProjectResponseModel create(EmployeeToProjectRequestModel requestModel) {

        // import data
        Project project = requestModel.getProject();
        Integer toDo = requestModel.getToDo();
        boolean toAdd = requestModel.getToAdd();
        boolean succeed;

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
