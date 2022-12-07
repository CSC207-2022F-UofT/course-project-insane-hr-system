package presenter;

import create_new_project.NewProjectResponseModel;
import create_new_project.NewProjectOutputBoundary;

public class NewProjectPresenter implements NewProjectOutputBoundary {

    @Override
    public NewProjectResponseModel prepareCreateProject(NewProjectResponseModel responseModel) {
        return responseModel;
    }
}
