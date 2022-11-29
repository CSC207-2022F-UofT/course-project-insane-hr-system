package screen_builder;

import ui.EmployeeBuilder;
import view_model.Table;
import view_model.UIDataModel;
import data_access.UIGateway;
import view_model.UserDataModel;
import view_model.UserType;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class DptHeadScreenBuilder extends UserScreenBuilder{
    public DptHeadScreenBuilder(UserDataModel dataModel) {
        super(dataModel);
    }

    // Implement all these methods to create our different frame.
    // there are some help function in super class, like getLeftRows, getRightRows,
    // we could add more helper function if you think it will be used in other frame.

    /**
     * This method set the Introduction part of the frame.
     *
     * @return is a long and well-formed string that contain all detail of the user or organization.
     */
    @Override
    protected String setIntro() {
        return super.setIntro();
    }

    /**
     * This method set the Introduction title.
     *
     * @return is a string that at least have the name of the user or organization.
     */
    @Override
    protected String setInfoTitle() {
        return super.setInfoTitle();
    }

    /**
     * This method set the Frame name in the top. Default is HR system.
     *
     * @return is a string of the frame name
     */
    @Override
    protected String setFrameName() {
        return super.setFrameName();
    }

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
        UserDataModel model = gateway.getFakeDataModel(1234, UserType.DPT_HEAD);
        ScreenBuilder builder = new EmployeeBuilder(model);
        JFrame application = builder.getView();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
