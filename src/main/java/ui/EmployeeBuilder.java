package ui;

import data_access.IUIGateway;
import data_access.UIGateway;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EmployeeBuilder extends IntegrationBuilder{
    private final UIDataModel dataModel;

    public EmployeeBuilder(UIDataModel dataModel) {
        super(dataModel);
        this.dataModel = dataModel;
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
        return dataModel.getIntro();
    }

    @Override
    protected String setInfoTitle() {
        return dataModel.getInfoTitle();
    }

    @Override
    protected String setFrameName() {
        return dataModel.getFrameName();
    }

    @Override
    protected Table setLeftTable() {
        return dataModel.getLeftTable();
    }

    @Override
    protected Table setRightTable() {
        return dataModel.getRightTable();
    }

    public static void main(String[] args) {
        IUIGateway gateway = new UIGateway();
        UIDataModel model = gateway.getUIDataModel(1234);
        EmployeeBuilder builder = new EmployeeBuilder(model);
        JFrame application = builder.getView();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
