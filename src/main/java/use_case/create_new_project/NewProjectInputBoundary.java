package use_case.create_new_project;

public interface NewProjectInputBoundary {
    NewProjectResponseModel create(NewProjectRequestModel requestModel);
}
