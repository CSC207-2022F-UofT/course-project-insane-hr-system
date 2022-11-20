package leave_request;

import entity.LeaveRequestProject;

// save the project and all its tasks
// update all members + head
public class LeaveRequestDsRequestModel {
    private LeaveRequestProject project;

    public LeaveRequestDsRequestModel(LeaveRequestProject project) {
        this.project = project;
    }

    public LeaveRequestProject getProject() {
        return project;
    }

    void setProject(LeaveRequestProject project) {
        this.project = project;
    }
}
