package add_department;

import entity.DepartmentFactory;
import entity.Organization;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
            return presenter.prepareFailView("Name already exists.");
        }

        String name = requestModel.getName();
        String description = requestModel.getDescription();
        Set<Integer> members = new HashSet<Integer>();
        LocalDateTime creationTime = LocalDateTime.now();

        Organization dpt = factory.create(name, 0, members, description, creationTime);
        AddDptDsRequestModel dsRequestModel = new AddDptDsRequestModel(dpt);
        dsGateway.save(dsRequestModel);

        AddDptResponseModel responseModel = new AddDptResponseModel(creationTime,dpt.getName(),dpt.getDescription());
        return presenter.prepareSuccessView(responseModel);
    }
}
