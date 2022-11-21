package delete_employee;

import entity.User;

public interface DeleteInputBoundary {
    DeleteResponseModel create(DeleteRequestModel requestModel);
}
