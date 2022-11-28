package screen_builder;

import view_model.*;
import ui.Integration;

import java.util.UUID;


public interface IUIGateway {

    UIDataModel getDataModelByID(UUID oid);
    UIDataModel getDataModelByID(Integration uid);

    UserDataModel getFakeDataModel(Integer uid, UserType userType);

    OrgDataModel getFakeDataModel(UUID oid, OrgType orgType);

    void updateDataModel(UIDataModel dataModel, UIDataModel newDataModel);
}
