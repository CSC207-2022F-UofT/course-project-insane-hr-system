package review_request;

import entity.Task;

import java.util.UUID;

public interface ReviewRequestDsGateway {
    void updateRequest(ReviewRequestDsRequestModel requestModel);
    Task getTask(UUID oid);
}
