package leave_request;

import entity.Role;

import java.util.List;

public interface LeaveRequestDsGateway {
    void save(LeaveRequestDsRequestModel requestModel);
    List<Role> getRoles(Integer uid);
}
