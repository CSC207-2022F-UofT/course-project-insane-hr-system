package DAOInterfaces;

import entity.Project;

import java.util.List;
import java.util.UUID;

public interface ProjectDAOInterface {

    // get all projects //
    List<Project> getAllProjects();

    // get one project //
    Project getProject(UUID id);

    // create a project //
    void createProject(Project project);

    // update a project //
    void updateProject(Project project);
}
