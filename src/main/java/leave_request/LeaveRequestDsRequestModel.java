package leave_request;

import entity.Project;

// save the project and all its tasks
// update all members + head
// update number of vacation days
public class LeaveRequestDsRequestModel {
    private Project project;
    private int vacationDays;

    public LeaveRequestDsRequestModel(Project project, int vacationDays) {
        this.project = project;
        this.vacationDays = vacationDays;
    }

    public Project getProject() {
        return project;
    }

    void setProject(Project project) {
        this.project = project;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }
}
