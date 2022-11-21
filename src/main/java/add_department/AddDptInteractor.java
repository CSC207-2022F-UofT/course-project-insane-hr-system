package add_department;

import entity.DepartmentFactory;

public class AddDptInteractor implements AddDptInputBoundary{
    final AddDptDsGateway dsGateway;
    final AddDptPresenter presenter;
    final DepartmentFactory factory;

    public AddDptInteractor(AddDptDsGateway dsGateway, AddDptPresenter presenter, DepartmentFactory factory) {
        this.dsGateway = dsGateway;
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public AddDptResponseModel create(AddDptRequestModel requestModel) {
        if (dsGateway.existByName(requestModel.getName())){
            presenter.prepareFailView("Name already exists.");

        }
    }
}
