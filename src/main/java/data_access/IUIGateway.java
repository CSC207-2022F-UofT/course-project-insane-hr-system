package data_access;

import ui.UIDataModel;

import java.util.UUID;

public interface IUIGateway {

    UIDataModel getUIDataModel(Integer uid);
    UIDataModel getUIDataModel(UUID oid);
}
