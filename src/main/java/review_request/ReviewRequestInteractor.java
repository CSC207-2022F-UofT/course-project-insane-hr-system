package review_request;

import entity.Curr;
import entity.Project;
import entity.Task;
import entity.User;

import java.util.UUID;

import static entity.Constants.CLOSED;

public class ReviewRequestInteractor implements ReviewRequestInputBoundary {
    final ReviewRequestDsGateway gateway;
    final ReviewRequestOutputBoundary outputBoundary;

    public ReviewRequestInteractor(ReviewRequestDsGateway gateway, ReviewRequestOutputBoundary outputBoundary) {
        this.gateway = gateway;
        this.outputBoundary = outputBoundary;
    }

    /**
     * This method takes in the request model and updates the response of the user to the leave request in the database.
     * @param requestModel a ReviewRequestRequestModel
     *
     * @return ReviewRequestResponseModel
     */
    @Override
    public ReviewRequestResponseModel reviewRequest(ReviewRequestRequestModel requestModel) {
        User user = Curr.getUser();
        UUID oid = requestModel.getOid();
        Task task = gateway.getTask(oid);
        Project project = task.getProject();
        boolean approval = requestModel.getApproval();

        task.setResults(approval);
        task.close();
        user.removeCurrTask(task);

        ReviewRequestDsRequestModel dsRequestModel = new ReviewRequestDsRequestModel(task, project);

        // if project has been closed
        if (project.getState().equals(CLOSED)) {
            user.removeCurrProject(project);
            if (isAllApprovals(project)) { // all managers have approved leave request
                dsRequestModel.setStatus("On Leave");
            }
        }

        gateway.updateRequest(dsRequestModel);

        ReviewRequestResponseModel responseModel = new ReviewRequestResponseModel(approval);
        return outputBoundary.prepareSuccessView(responseModel);
    }

    private boolean isAllApprovals(Project project) {
        for (Task t: project.getTasks()) {
            boolean approval = (boolean) t.getResults();
            if (!approval) {
                return false;
            }
        }
        return true;
    }
}
