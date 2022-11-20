package ProjectMgt;

import entity.Project;
import entity.User;

public interface ProjectMgtGateway {

    void save(ProjectMgtInteractor interactor);

    void saveProject(Project project);

    void savePM(User PM);
}
