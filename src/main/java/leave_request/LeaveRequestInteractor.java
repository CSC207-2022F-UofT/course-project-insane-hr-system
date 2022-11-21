package leave_request;

import entity.*;

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

    @Override
    public LeaveRequestResponseModel create(LeaveRequestRequestModel requestModel) {
        // get current user and relevant data
        User user = Curr.getUser();
        int vacationDays = user.getVacationDays();
        int leaveDays = requestModel.getLeaveDays();
        String leaveType = requestModel.getLeaveType().toString();
        String startDate = requestModel.getStartDate().toString();
        String returnDate = requestModel.getReturnDate().toString();

        if (!requestModel.isReturnAfter()) {
            return outputBoundary.prepareFailureView("Return date have to be after the start date.");
        }

        if (requestModel.getLeaveType() == LeaveType.VACATION) {
            if (vacationDays < leaveDays) {
                return outputBoundary.prepareFailureView("You do not have enough vacation days left\nRequested: "
                        + leaveDays + " Remaining: " + vacationDays);
            }
            user.setVacationDays(vacationDays - leaveDays); // update user's vacation days
        }

        // get all superiors of user
        Set<Integer> members = new HashSet<>();
        for (Project p : user.getProjects()) {
            Integer head = p.getHead();
            if (RoleAllowed.isHeadOf(gateway.getRoles(head), user.getRoles())) {
                members.add(head);
            }
        }

        // e.g. "Tim Lan's VACATION Leave Request (2022-11-17 until 2022-12-12 return)"
        String projectName = user.getName() + "'s " + leaveType + " Leave Request (" + startDate + " until " + returnDate
                + " return)";
        Project project = projectBuilder.createProject(projectName, requestModel.getMessage(), members);

        // save the project and all its tasks
        LeaveRequestDsRequestModel dsRequestModel = new LeaveRequestDsRequestModel(project);
        gateway.save(dsRequestModel);

        LeaveRequestResponseModel responseModel = new LeaveRequestResponseModel(leaveType, startDate, returnDate,
                project.getCreateTime().toString());
        return outputBoundary.prepareSuccessView(responseModel);
    }
}
