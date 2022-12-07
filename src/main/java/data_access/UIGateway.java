package data_access;

import screen_builder.IUIGateway;
import view_model.*;
import ui.Integration;

import java.util.UUID;

public class UIGateway implements IUIGateway {
    @Override
    public ViewModel getDataModelByID(UUID oid) {
        return null;
    }

    @Override
    public ViewModel getDataModelByID(Integration uid) {
        return null;
    }

    @Override
    public ViewModel getFakeDataModel(Integer uid, UserType userType) {
        Table left = new Table(new String[]{"Employee Name"}, new Object[][]{new Object[]{"Bob"}, new Object[]{"john"}}, new Object[]{"11","22"});
        Table right = new Table(new String[]{"Head12 Name"}, new Object[][]{new Object[]{"Leon"}, new Object[]{"Alice"}}, new Object[]{"10","20"});
        String intro = String.format("Introduction:\nUid:\t%s\n", uid);
        return new ViewModel(uid, "FrameName", "User Name", intro, left, right);
    }

    @Override
    public ViewModel getFakeDataModel(Integer uid, OrgType orgType) {
        Table left = new Table(new String[]{"Member Name"}, new Object[][]{new Object[]{"Bob"}, new Object[]{"john"}}, new Object[]{"11","22"});
        Table right = new Table(new String[]{"Task Name"}, new Object[][]{new Object[]{"Leon"}, new Object[]{"Alice"}}, new Object[]{"10","20"});
        String intro = String.format("Introduction:\n%s is looking\n", uid);
        return new ViewModel(uid, "FrameName", "User Name", intro, left, right);
    }

    @Override
    public void updateDataModel(ViewModel dataModel, ViewModel newDataModel) {
        dataModel.updateAll(newDataModel);
    }
}
