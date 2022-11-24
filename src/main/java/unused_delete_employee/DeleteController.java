package unused_delete_employee;

import entity.User;

public class DeleteController {
    final DeleteInputBoundary inputBoundary;


    public DeleteController(DeleteInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    DeleteResponseModel create(User user) {
        DeleteRequestModel requestModel = new DeleteRequestModel(user);
        return inputBoundary.create(requestModel);
    }
}
