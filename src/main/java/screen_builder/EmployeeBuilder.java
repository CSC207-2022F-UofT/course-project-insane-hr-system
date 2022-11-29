package ui;

import check_profile_validation.FileType;
import data_access.UIGateway;
import screen_builder.IUIGateway;
import screen_builder.ScreenBuilder;
import view_model.Table;
import view_model.UIDataModel;
import view_model.UserType;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EmployeeBuilder extends ScreenBuilder {
    private final UIDataModel dataModel;

    public EmployeeBuilder(UIDataModel dataModel) {
        super(dataModel);
        this.dataModel = dataModel;
    }

    @Override
    public JPanel customizeLeftPanel() {
        JPanel panel = new JPanel();
        JButton requestButton = new JButton("Leave Request");
        panel.add(requestButton);
        requestButton.addActionListener(e -> {
            LeaveRequestUI ui = new LeaveRequestUI(getView());
            ui.setVisible(true);
        });
        return panel;
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
        UIDataModel model = gateway.getFakeDataModel(1234, UserType.EMPLOYEE);
        EmployeeBuilder builder = new EmployeeBuilder(model);
        JFrame application = builder.getView();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
