package screen_builder;

import data_access.UIGateway;
import presenter.IViewModel;
import ui.ScreenBuilder;
import ui.LeaveRequestUI;
import view_model.Table;
import view_model.UserType;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EmployeeBuilder extends ScreenBuilder {
    private final IViewModel dataModel;

    public EmployeeBuilder(IViewModel dataModel) {
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
    public String setIntro() {
        return dataModel.getIntro();
    }

    @Override
    public String setInfoTitle() {
        return dataModel.getInfoTitle();
    }

    @Override
    public String setFrameName() {
        return dataModel.getFrameName();
    }

    @Override
    public Table setLeftTable() {
        return dataModel.getLeftTable();
    }

    @Override
    public Table setRightTable() {
        return dataModel.getRightTable();
    }

    public static void main(String[] args) {
        IUIGateway gateway = new UIGateway();
        IViewModel model = gateway.getFakeDataModel(1234, UserType.PROJECT_MANAGER);
        EmployeeBuilder builder = new EmployeeBuilder(model);
        JFrame application = builder.getView();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
