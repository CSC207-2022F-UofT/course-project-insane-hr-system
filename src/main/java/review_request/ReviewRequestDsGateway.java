package review_request;

public interface ReviewRequestDsGateway {
    void updateRequest(ReviewRequestDsRequestModel requestModel);
    void setStatus(Integer uid, String status);
}
