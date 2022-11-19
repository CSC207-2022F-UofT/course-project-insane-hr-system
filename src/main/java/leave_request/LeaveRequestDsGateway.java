package leave_request;

import entity.User;

public interface LeaveRequestDsGateway {
    User retrieve(Integer uid);
    void save(LeaveRequestDsRequestModel requestModel);
}
