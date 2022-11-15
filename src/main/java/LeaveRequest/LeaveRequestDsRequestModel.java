package LeaveRequest;

import Entity.LeaveRequestProject;

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
