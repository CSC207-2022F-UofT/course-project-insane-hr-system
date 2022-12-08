package use_case.leave_request;

import entity.user.User;

public interface LeaveRequestDsGateway {
    void save(LeaveRequestDsRequestModel requestModel);
    User getUser(Integer uid);
}
