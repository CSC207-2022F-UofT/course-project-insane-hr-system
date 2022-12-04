package create_new_project;

import entity.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class NewProjectInteractor implements NewProjectInputBoundary {


    @Override
    public NewProjectResponseModel create(NewProjectRequestModel requestModel) {

        // set initial empty project parameters
        int PMid = requestModel.getProjectManagerID();
        UUID oid = UUID.randomUUID();
        Set<Integer> teams = Set.of();
        List<Task> tasks = List.of();
        int funds = requestModel.getFunds();
        String name = requestModel.getName();
        String description = requestModel.getDescription();
        LocalDateTime createTime = LocalDateTime.now();
        Department dpt = requestModel.getDpt();
        LocalDateTime closeTime = null;
        Boolean finished = false;

        // create new project
        Project project = new CommonProject(oid, name, PMid, teams, description, createTime,
                dpt, tasks, funds);

        // return response model
        return new NewProjectResponseModel(PMid, teams, tasks, funds, name, description,
                createTime, dpt, closeTime, finished, project);
    }

}
