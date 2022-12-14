package use_case.add_remove_employee_to_project;

import entity.project.Project;

public class EmployeeToProjectResponseModel {
    Project project;
    boolean succeed;

    public EmployeeToProjectResponseModel(Project project, boolean succeed) {
        this.project = project;
        this.succeed = succeed;
    }

    public Project getProject() {
        return project;
    }

    public boolean getSucceed() {
        return succeed;
    }
}
