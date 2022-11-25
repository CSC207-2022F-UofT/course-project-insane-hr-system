package review_request;

public class ReviewRequestInteractor implements ReviewRequestInputBoundary {
    final ReviewRequestDsGateway gateway;
    final ReviewRequestOutputBoundary outputBoundary;

    public ReviewRequestInteractor(ReviewRequestDsGateway gateway, ReviewRequestOutputBoundary outputBoundary) {
        this.gateway = gateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public ReviewRequestResponseModel reviewRequest(ReviewRequestRequestModel requestModel) {
        return null;
    }
}
