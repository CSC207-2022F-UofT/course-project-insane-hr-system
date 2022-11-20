package PositionMgt;

import Entity.User;

public interface PositionMgtInputBoundary {
    PositionMgtRequestModel create(PositionMgtRequestModel requestModel);

    PositionMgtResponseModel create(PositionMgtResponseModel responseModel);

    void promoteUser(User user);

    void demoteUser(User user);
}
