package controller;

import create_new_project.NewProjectInputBoundary;
import create_new_project.NewProjectRequestModel;
import create_new_project.NewProjectResponseModel;

public class NewProjectController {

    public static NewProjectInputBoundary ProjectInput;

    public NewProjectController(NewProjectInputBoundary projectInput) {
        ProjectInput = projectInput;
    }

    public static NewProjectResponseModel create(int PMid, int funds, String name, String description, String dpt) {
        NewProjectRequestModel requestModel = new NewProjectRequestModel(PMid, funds, name, description, dpt);
        return ProjectInput.create(requestModel);
    }
}
