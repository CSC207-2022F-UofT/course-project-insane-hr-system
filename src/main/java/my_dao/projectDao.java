package my_dao;

import DAOInterfaces.ProjectDAOInterface;
import entity.Project;

import java.util.List;
import java.util.UUID;

public class projectDao implements ProjectDAOInterface {
    @Override
    public List<Project> getAllProjects() {
        return null;
    }

    @Override
    public Project getProject(UUID id) {
        return null;
    }

    @Override
    public void createProject(Project project) {

    }

    @Override
    public void updateProject(Project project) {

    }
}
