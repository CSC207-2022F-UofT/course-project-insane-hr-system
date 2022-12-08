package create_new_project;

import entity.Department;
import entity.Project;
import entity.User;

import java.util.List;
import java.util.UUID;

public interface NewProjectGateway {

    void save(NewProjectResponseModel responseModel);

    List<Department> getDptList();

    Project getProject(UUID oid);
}
