package use_case.leave_request;

import entity.project.LeaveType;
import entity.project.Project;
import entity.project.ProjectBuilder;
import entity.role.RoleAllowed;
import entity.user.User;

import java.util.HashSet;
import java.util.Set;

public class LeaveRequestInteractor implements LeaveRequestInputBoundary {
    private final LeaveRequestDsGateway gateway;
    private final LeaveRequestOutputBoundary outputBoundary;
    private final ProjectBuilder projectBuilder;

    public LeaveRequestInteractor(LeaveRequestDsGateway gateway, LeaveRequestOutputBoundary outputBoundary,
                                  ProjectBuilder projectBuilder) {
        this.gateway = gateway;
        this.outputBoundary = outputBoundary;
        this.projectBuilder = projectBuilder;
    }

    /**
     * This method takes in the request model and creates a leave request which is saved to the database.
     * @param requestModel a LeaveRequestRequestModel
     *
     * @return LeaveRequestResponseModel
     */
    @Override
    public LeaveRequestResponseModel create(LeaveRequestRequestModel requestModel) {
        // get current user and relevant data
        User user = requestModel.getUser();
        int vacationDays = user.getVacationDays();
        int leaveDays = requestModel.getLeaveDays();
        LeaveType leaveType = requestModel.getLeaveType();
        String startDate = requestModel.getStartDate().toString();
        String returnDate = requestModel.getReturnDate().toString();

        if (!requestModel.isReturnAfter()) {
            return outputBoundary.prepareFailureView("Return date have to be after the start date.");
        }

        if (leaveType == LeaveType.VACATION && vacationDays < leaveDays) {
                return outputBoundary.prepareFailureView("You do not have enough vacation days left\nRequested: "
                        + leaveDays + " Remaining: " + vacationDays);
        }

        // get all superiors of user
        Set<Integer> members = new HashSet<>();
        members.add(user.getDpt().getHead());
        for (Project p : user.getProjects()) {
            Integer h = p.getHead();
            User head = gateway.getUser(h);
            if (RoleAllowed.isHeadOf(head.getRoles(), user.getRoles())) {
                members.add(h);
            }
        }

        // e.g. "Tim Lan's VACATION Leave Request (2022-11-17 until 2022-12-12 return)"
        String projectName = user.getName() + "'s " + leaveType.toString() + " Leave Request (" + startDate + " until " + returnDate
                + " return)";
        Project project = projectBuilder.createProject(projectName, requestModel.getMessage(), members, leaveDays, leaveType);

        // save the project and all its tasks
        LeaveRequestDsRequestModel dsRequestModel = new LeaveRequestDsRequestModel(project);
        gateway.save(dsRequestModel);

        // generate ResponseModel and return
        LeaveRequestResponseModel responseModel = new LeaveRequestResponseModel(leaveType.toString(), startDate, returnDate,
                project.getCreateTime().toString());
        return outputBoundary.prepareSuccessView(responseModel);
    }
}
