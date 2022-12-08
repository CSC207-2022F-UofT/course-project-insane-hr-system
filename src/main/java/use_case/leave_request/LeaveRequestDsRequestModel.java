package use_case.leave_request;

import entity.project.Project;

// save the project and all its tasks
// update all members + head
public class LeaveRequestDsRequestModel {
    private Project project;

    public LeaveRequestDsRequestModel(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    void setProject(Project project) {
        this.project = project;
    }
}
