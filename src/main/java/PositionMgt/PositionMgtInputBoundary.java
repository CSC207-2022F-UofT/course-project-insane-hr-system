package PositionMgt;

import entity.User;

public interface PositionMgtInputBoundary {
    PositionMgtResponseModel create(PositionMgtRequestModel requestModel);

    void promoteUser(User user);

    void demoteUser(User user);
}
