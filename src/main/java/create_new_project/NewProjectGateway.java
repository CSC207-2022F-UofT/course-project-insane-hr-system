package create_new_project;

import entity.Project;
import entity.User;

public interface NewProjectGateway {

    void save(NewProjectResponseModel responseModel);
}
