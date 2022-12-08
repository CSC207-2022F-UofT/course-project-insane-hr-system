package create_new_project;

import entity.Department;
import entity.Project;
import entity.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class NewProjectResponseModel {
    Project project;

    public NewProjectResponseModel(Project project) {
        this.project = project;
    }
    public Project getProject() {
        return project;
    }
}
