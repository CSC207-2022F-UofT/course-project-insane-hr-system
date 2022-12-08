package controller;

import use_case.create_new_project.NewProjectInputBoundary;
import use_case.create_new_project.NewProjectInteractor;
import use_case.create_new_project.NewProjectRequestModel;
import use_case.create_new_project.NewProjectResponseModel;

public class NewProjectController {

    public NewProjectInputBoundary projectInput = new NewProjectInteractor();

    public NewProjectController(NewProjectInputBoundary projectInput) {
        this.projectInput = projectInput;
    }

    public NewProjectResponseModel create(int PMid, int funds, String name, String description, String dpt) {
        NewProjectRequestModel requestModel = new NewProjectRequestModel(PMid, funds, name, description, dpt);
        return projectInput.create(requestModel);
    }
}
