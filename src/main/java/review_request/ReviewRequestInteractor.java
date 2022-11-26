package review_request;

import entity.Curr;
import entity.Project;
import entity.Task;
import entity.User;

import static entity.Constants.CLOSED;

public class ReviewRequestInteractor implements ReviewRequestInputBoundary {
    final ReviewRequestDsGateway gateway;
    final ReviewRequestOutputBoundary outputBoundary;

    public ReviewRequestInteractor(ReviewRequestDsGateway gateway, ReviewRequestOutputBoundary outputBoundary) {
        this.gateway = gateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public ReviewRequestResponseModel reviewRequest(ReviewRequestRequestModel requestModel) {
        User user = Curr.getUser();
        Task task = requestModel.getTask();
        Project project = task.getProject();
        boolean approval = requestModel.getApproval();

        task.setResults(approval);
        task.close();
        user.removeCurrTask(task);

        ReviewRequestDsRequestModel dsRequestModel = new ReviewRequestDsRequestModel(task, project);

        // if project has been closed
        if (project.getState().equals(CLOSED)) {
            user.removeCurrProject(project);
            if (checkResults(project)) { // all managers have approved leave request
                String status = "On Leave";
                dsRequestModel.setStatus(status);
            }
        }

        gateway.updateRequest(dsRequestModel);

        ReviewRequestResponseModel responseModel = new ReviewRequestResponseModel(approval);
        return outputBoundary.prepareSuccessView(responseModel);
    }

    private boolean checkResults(Project project) {
        for (Task t: project.getTasks()) {
            boolean approval = (boolean) t.getResults();
            if (!approval) {
                return false;
            }
        }
        return true;
    }
}
