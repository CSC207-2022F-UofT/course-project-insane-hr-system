package presenter;

import add_remove_employee_to_project.EmployeeToProjectResponseModel;
import add_remove_employee_to_project.EmployeeToProjectOutputBoundary;

public class EmployeeToProjectPresenter implements EmployeeToProjectOutputBoundary {

    @Override
    public EmployeeToProjectResponseModel prepareEmployeeEdit(EmployeeToProjectResponseModel responseModel) {
        return responseModel;
    }
}
