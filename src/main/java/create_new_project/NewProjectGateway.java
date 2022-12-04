package create_new_project;

import entity.Project;
import entity.User;

public interface NewProjectGateway {

    void save(NewProjectInteractor interactor);

    void saveProject(Project project);

    void savePM(User PM);
}
