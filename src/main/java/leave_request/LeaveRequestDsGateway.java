package leave_request;

import entity.User;

public interface LeaveRequestDsGateway {
    void save(LeaveRequestDsRequestModel requestModel);
    User getUser(Integer uid);
}
