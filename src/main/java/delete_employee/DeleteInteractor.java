package delete_employee;

import entity.User;

import java.time.LocalDateTime;

public class DeleteInteractor implements DeleteInputBoundary{
    final DeleteDsGateway dsGateway;

    final DeletePresentor presenter;

    public DeleteInteractor(DeleteDsGateway dsGateway, DeletePresentor presenter) {
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }


    @Override
    public DeleteResponseModel create(DeleteRequestModel requestModel) {
        User user = requestModel.getUser();
        String name = user.getName();
        int id = user.getId();
        dsGateway.delete(user);
        DeleteResponseModel responseModel = new DeleteResponseModel(id, name, LocalDateTime.now());
        return presenter.prepareSuccessView(responseModel);
    }
}
