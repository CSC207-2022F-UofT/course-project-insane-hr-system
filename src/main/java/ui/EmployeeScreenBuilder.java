package ui;

import ViewModel.Table;
import ViewModel.UIDataModel;
import data_access.IUIGateway;
import data_access.UIGateway;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EmployeeScreenBuilder extends ScreenBuilder {
    public EmployeeScreenBuilder(UIDataModel dataModel) {
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
        UIDataModel model = gateway.getUIDataModel(1234);
        ScreenBuilder builder = new EmployeeScreenBuilder(model);
        JFrame application = builder.getView();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
