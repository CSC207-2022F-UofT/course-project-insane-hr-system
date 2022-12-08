package presenter;

import use_case.create_new_project.NewProjectResponseModel;
import use_case.create_new_project.NewProjectOutputBoundary;

public class NewProjectPresenter implements NewProjectOutputBoundary {

    @Override
    public NewProjectResponseModel prepareCreateProject(NewProjectResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public NewProjectResponseModel prepareFailureView(String error) {
        throw new RuntimeException(error);
    }
}
