package use_case.create_new_project;

import entity.Project;

public class NewProjectResponseModel {
    Project project;

    public NewProjectResponseModel(Project project) {
        this.project = project;
    }
    public Project getProject() {
        return project;
    }
}
