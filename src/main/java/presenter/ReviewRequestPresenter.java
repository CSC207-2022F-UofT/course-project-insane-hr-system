package presenter;

import use_case.review_request.ReviewRequestOutputBoundary;
import use_case.review_request.ReviewRequestResponseModel;

public class ReviewRequestPresenter implements ReviewRequestOutputBoundary {
    @Override
    public ReviewRequestResponseModel prepareSuccessView(ReviewRequestResponseModel responseModel) {
        return responseModel;
    }
}
