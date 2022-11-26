package data_access;

import ViewModel.Table;
import ViewModel.UIDataModel;

import java.util.UUID;

public class UIGateway implements IUIGateway{
    @Override
    public UIDataModel getUIDataModel(Integer uid) {
        Table left = new Table(new String[]{"Employee Name"}, new Object[][]{new Object[]{"Bob"}, new Object[]{"john"}}, new Object[]{"11","22"});
        Table right = new Table(new String[]{"Head12 Name"}, new Object[][]{new Object[]{"Leon"}, new Object[]{"Alice"}}, new Object[]{"10","20"});
        String intro = String.format("Introduction:\nUid:\t%s\n", uid);
        return new UIDataModel("FrameName- UserFile", "Leon", intro, left, right);
    }

    @Override
    public UIDataModel getUIDataModel(UUID oid) {
        return new UIDataModel("FrameName", "OrganizationFile", "Introduction");
    }
}
