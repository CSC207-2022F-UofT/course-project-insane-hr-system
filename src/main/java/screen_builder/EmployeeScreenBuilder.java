package screen_builder;

import view_model.Table;
import view_model.UIDataModel;
import data_access.UIGateway;
import view_model.UserDataModel;
import view_model.UserType;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EmployeeScreenBuilder extends UserScreenBuilder {
    public EmployeeScreenBuilder(UserDataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void customizeLeftButton() {
        super.customizeLeftButton();
        System.out.println("EmployeeLeftButton");
    }

    @Override
    public void customizeRightButton() {
        super.customizeRightButton();
        System.out.println("EmployeeRightButton");
    }


    @Override
    protected String setIntro() {
        return super.getDataModel().getIntro();
    }

    @Override
    protected String setInfoTitle() {
        return super.getDataModel().getInfoTitle();
    }

    @Override
    protected String setFrameName() {
        return super.getDataModel().getFrameName();
    }

    @Override
    protected Table setLeftTable() {
        return super.getDataModel().getLeftTable();
    }

    @Override
    protected Table setRightTable() {
        return super.getDataModel().getRightTable();
    }

    @Override
    protected JPanel customizeLeftPanel() {
        return super.customizeLeftPanel();
    }

    public static void main(String[] args) {
        IUIGateway gateway = new UIGateway();
        UserDataModel model = gateway.getFakeDataModel(1234, UserType.EMPLOYEE);
        ScreenBuilder builder = new EmployeeScreenBuilder(model);
        JFrame application = builder.getIntroOnly();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}