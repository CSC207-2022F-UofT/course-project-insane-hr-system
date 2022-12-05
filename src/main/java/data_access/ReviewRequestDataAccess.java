package data_access;

import entity.Task;
import review_request.ReviewRequestDsGateway;
import review_request.ReviewRequestDsRequestModel;

import java.util.UUID;

public class ReviewRequestDataAccess implements ReviewRequestDsGateway {
    @Override
    public void updateRequest(ReviewRequestDsRequestModel requestModel) {

    }

    @Override
    public Task getTask(UUID oid) {
        return null;
    }
}
