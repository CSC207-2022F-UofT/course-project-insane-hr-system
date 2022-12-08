package add_remove_employee_to_project;

public interface EmployeeToProjectInputBoundary {
    EmployeeToProjectResponseModel create(EmployeeToProjectRequestModel requestModel);
}
