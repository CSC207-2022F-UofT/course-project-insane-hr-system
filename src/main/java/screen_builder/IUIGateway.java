package screen_builder;

import view_model.*;
import ui.Integration;

import java.util.UUID;


public interface IUIGateway {

    ViewModel getDataModelByID(UUID oid);
    ViewModel getDataModelByID(Integration uid);

    ViewModel getFakeDataModel(Integer uid, UserType userType);


    ViewModel getFakeDataModel(Integer uid, OrgType orgType);

    void updateDataModel(ViewModel dataModel, ViewModel newDataModel);
}
