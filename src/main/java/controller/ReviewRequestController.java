package controller;

import entity.Task;
import review_request.ReviewRequestInputBoundary;
import review_request.ReviewRequestRequestModel;
import review_request.ReviewRequestResponseModel;

public class ReviewRequestController {
    final ReviewRequestInputBoundary inputBoundary;

    public ReviewRequestController(ReviewRequestInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    ReviewRequestResponseModel reviewRequest(Task task, boolean approval) {
        ReviewRequestRequestModel requestModel = new ReviewRequestRequestModel(task, approval);
        return inputBoundary.reviewRequest(requestModel);
    }
}
