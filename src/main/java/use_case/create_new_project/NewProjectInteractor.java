package use_case.create_new_project;

import data_access.NewProjectDataAccess;
import entity.*;
import entity.project.CommonProject;
import entity.project.Project;
import entity.task.Task;
import presenter.NewProjectPresenter;

import java.time.LocalDateTime;
import java.util.*;

public class NewProjectInteractor implements NewProjectInputBoundary {

    private final NewProjectGateway newgateway = new NewProjectDataAccess();
    private final NewProjectOutputBoundary presenter = new NewProjectPresenter();
    @Override
    public NewProjectResponseModel create(NewProjectRequestModel requestModel) {

        // set initial empty project parameters
        int PMid = requestModel.getProjectManagerID();
        UUID oid = UUID.randomUUID();
        Set<Integer> teams = new HashSet<>();
        List<Task> tasks = new ArrayList<>();
        int funds = requestModel.getFunds();
        String name = requestModel.getName();
        String description = requestModel.getDescription();
        LocalDateTime createTime = LocalDateTime.now();
        Department dpt = getDpt(requestModel.getDpt());

        if (dpt == null) {
            return presenter.prepareFailureView("Department not found.");
        }

        // create new project
        Project project = new CommonProject(oid, name, PMid, teams, description, createTime,
                dpt, tasks, funds);

        NewProjectResponseModel responseModel = new NewProjectResponseModel(project);

        newgateway.save(responseModel);

        // return response model
        return presenter.prepareCreateProject(responseModel);
    }

    private Department getDpt(String dpt) {
        List<Department> ldpt = newgateway.getDptList();
        for (Department dp: ldpt) {
            if (dpt.equals(dp.getName())) {
                return dp;
            }
        }
        return null;
    }
}
