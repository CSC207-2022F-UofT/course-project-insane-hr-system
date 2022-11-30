package presenter;

import review_request.ReviewRequestOutputBoundary;
import review_request.ReviewRequestResponseModel;

public class ReviewRequestPresenter implements ReviewRequestOutputBoundary {
    @Override
    public ReviewRequestResponseModel prepareSuccessView(ReviewRequestResponseModel responseModel) {
        return responseModel;
    }
}
