package controller;

import use_case.review_request.ReviewRequestInputBoundary;
import use_case.review_request.ReviewRequestRequestModel;
import use_case.review_request.ReviewRequestResponseModel;

import java.util.UUID;

public class ReviewRequestController {
    final ReviewRequestInputBoundary inputBoundary;

    public ReviewRequestController(ReviewRequestInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public ReviewRequestResponseModel reviewRequest(UUID oid, boolean approval) {
        ReviewRequestRequestModel requestModel = new ReviewRequestRequestModel(oid, approval);
        return inputBoundary.reviewRequest(requestModel);
    }
}
