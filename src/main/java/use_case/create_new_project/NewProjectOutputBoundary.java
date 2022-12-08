package use_case.create_new_project;

public interface NewProjectOutputBoundary {
    NewProjectResponseModel prepareCreateProject(NewProjectResponseModel responseModel);
    NewProjectResponseModel prepareFailureView(String error);
}
