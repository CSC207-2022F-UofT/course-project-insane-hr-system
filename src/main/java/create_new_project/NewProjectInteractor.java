package create_new_project;

import data_access.NewProjectDataAccess;
import entity.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class NewProjectInteractor implements NewProjectInputBoundary {

    private final NewProjectGateway newgateway = new NewProjectDataAccess();
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
        Department dpt = getDpt(requestModel.getDpt());

        // create new project
        Project project = new CommonProject(oid, name, PMid, teams, description, createTime,
                dpt, tasks, funds);

        // return response model
        return new NewProjectResponseModel(project);
    }

    private Department getDpt(String dpt) {
        List<Department> ldpt = newgateway.getDptList();
        for (Department dp: ldpt) {
            if (Objects.equals(dp.getName(), dpt)) {
                return dp;
            }
        }
        return null;
    }
}
