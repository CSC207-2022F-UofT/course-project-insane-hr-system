package data_access;

import entity.User;
import leave_request.LeaveRequestDsGateway;
import leave_request.LeaveRequestDsRequestModel;

public class LeaveRequestDataAccess implements LeaveRequestDsGateway {
    @Override
    public void save(LeaveRequestDsRequestModel requestModel) {

    }

    @Override
    public User getUser(Integer uid) {
        return null;
    }
}
