package DAOInterfaces;

import entity.Project;

import java.util.List;
import java.util.UUID;

public interface ProjectDAOInterface {

    // get all projects //
    public List<Project> getAllProjects();

    // get one project //
    public Project getProject(UUID id);

    // create a project //
    public void createProject(Project project);

    // update a project //
    public void updateProject(Project project);
}
