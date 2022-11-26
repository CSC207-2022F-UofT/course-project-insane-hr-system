package data_access;

import ViewModel.UIDataModel;

import java.util.UUID;

public interface IUIGateway {

    UIDataModel getUIDataModel(Integer uid);
    UIDataModel getUIDataModel(UUID oid);
}
