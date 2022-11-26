package ui;

import ViewModel.Table;
import ViewModel.UIDataModel;
import data_access.IUIGateway;
import data_access.UIGateway;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TaskScreenForDHBuilder extends TaskScreenBuilder{
    public TaskScreenForDHBuilder(UIDataModel dataModel) {
        super(dataModel);
    }


    // Implement all these methods to create our different frame.
    // there are some help function in super class, like getLeftRows, getRightRows,
    // we could add more helper function if you think it will be used in other frame.


    /**
     * This method set the Left table using Table model.
     *
     * @return a Table that will be present in left JTable.
     */
    @Override
    protected Table setLeftTable() {
        return super.setLeftTable();
    }

    /**
     * This method set the Right table using Table model.
     *
     * @return a Table that will be present in right JTable.
     */
    @Override
    protected Table setRightTable() {
        return super.setRightTable();
    }

    @Override
    protected String setLeftButtonLabel() {
        return super.setLeftButtonLabel();
    }

    /**
     * This method will be invoked after the left button is clicked.
     */
    @Override
    protected void customizeLeftButton() {
        super.customizeLeftButton();
    }

    @Override
    protected String setRightButtonLabel() {
        return super.setRightButtonLabel();
    }

    /**
     * This method will be invoked after the right button is clicked.
     */
    @Override
    protected void customizeRightButton() {
        super.customizeRightButton();
    }

    @Override
    protected JPanel customizeLeftPanel() {
        return super.customizeLeftPanel();
    }
    public static void main(String[] args) {
        IUIGateway gateway = new UIGateway();
        UIDataModel model = gateway.getUIDataModel(1234);
        ScreenBuilder builder = new TaskScreenForDHBuilder(model);
        JFrame application = builder.getView();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
