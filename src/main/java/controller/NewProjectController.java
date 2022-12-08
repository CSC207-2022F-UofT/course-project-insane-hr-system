package controller;

import create_new_project.NewProjectInputBoundary;
import create_new_project.NewProjectInteractor;
import create_new_project.NewProjectRequestModel;
import create_new_project.NewProjectResponseModel;

public class NewProjectController {

    public final NewProjectInputBoundary projectInput = new NewProjectInteractor();

    public NewProjectController(NewProjectInputBoundary projectInput) {
        projectInput = projectInput;
    }

    public NewProjectResponseModel create(int PMid, int funds, String name, String description, String dpt) {
        NewProjectRequestModel requestModel = new NewProjectRequestModel(PMid, funds, name, description, dpt);
        return projectInput.create(requestModel);
    }
}
