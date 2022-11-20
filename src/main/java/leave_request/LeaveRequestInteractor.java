package leave_request;

import entity.*;

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
        User user = Curr.getUser();
        int vacationDays = user.getVacationDays();
        int leaveDays = requestModel.getLeaveDays();
        String leaveType = requestModel.getLeaveType().toString();
        String startDate = requestModel.getStartDate().toString();
        String returnDate = requestModel.getReturnDate().toString();

        if (!requestModel.isReturnAfter()) {
            return outputBoundary.prepareFailureView("Return date have to be after the start date.");
        } else if (requestModel.getLeaveType() == LeaveType.VACATION & vacationDays < leaveDays) {
            return outputBoundary.prepareFailureView("You do not have enough vacation days left\nRequested: " +
                    leaveDays + " Remaining: " + vacationDays);
        }

        user.setVacationDays(vacationDays - leaveDays);

        // e.g. "Tim Lan's VACATION Leave Request (2022-11-17 until 2022-12-12 return)"
        String projectName = user.getName() + "'s " + leaveType + " Leave Request (" + startDate + " until " + returnDate
                + " return)";
        Project project = projectBuilder.createProject(projectName, requestModel.getMessage());

        LeaveRequestDsRequestModel dsRequestModel = new LeaveRequestDsRequestModel(project);
        gateway.save(dsRequestModel);

        LeaveRequestResponseModel responseModel = new LeaveRequestResponseModel(leaveType, startDate, returnDate,
                project.getCreateTime().toString());
        return outputBoundary.prepareSuccessView(responseModel);
    }
}
