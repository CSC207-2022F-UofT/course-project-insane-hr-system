package ui;

import ViewModel.Table;
import ViewModel.UIDataModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ScreenBuilder {
    private final UIDataModel dataModel;
    private final Integration view = new Integration();

    public ScreenBuilder(UIDataModel dataModel) {

        this.dataModel = dataModel;
        // Add view to the dataModel observable.
        this.dataModel.addObserver(view);

    }


    /**
     * This method initialize the frame.
     */
    protected void initialization(){
//        try {
//            view.setIconImage(ImageIO.read(new File("java/ui/logo.png")));
//        } catch (IOException e) {
//            throw new RuntimeException("Didn't find Logo!", e);
//        }
    }

    /**
     * This method set the Introduction part of the frame.
     * @return is a long and well-formed string that contain all detail of the user or organization.
     */
    protected String setIntro() {
        return "IntegrationIntro";
    }

    /**
     * This method set the Introduction title.
     * @return is a string that at least have the name of the user or organization.
     */
    protected String setInfoTitle() {
        return "Integration ObjectName";
    }

    /**
     * This method set the Frame name in the top. Default is HR system.
     * @return is a string of the frame name
     */
    protected String setFrameName() {
        return "HR System";
    }

    /**
     * This method set the Left table using Table model.
     * @return a Table that will be present in left JTable.
     */
    protected Table setLeftTable() {
        return new Table(new String[]{"Left Table need to be override!"}, new Object[][]{new Object[]{"Leon"}, new Object[]{"Alice"}}, new Object[]{10,20});
    }

    /**
     * This method set the Right table using Table model.
     * @return a Table that will be present in right JTable.
     */
    protected Table setRightTable(){
        return new Table(new String[]{"Right Table need to be override!"}, new Object[][]{new Object[]{"Leon"}, new Object[]{"Alice"}}, new Object[]{10,20});
    }

    protected String setLeftButtonLabel() {
        return "Create a useless dialog";
    }
    /**
     * This method will be invoked after the left button is clicked.
     */
    protected void customizeLeftButton(){

        JOptionPane.showMessageDialog(view,
                "Left button haven't customized",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }

    protected String setRightButtonLabel() {
        return "Add select row into introduction";
    }
    /**
     * This method will be invoked after the right button is clicked.
     */
    protected void customizeRightButton(){
        int[] nums = view.getRightTable().getSelectedRows();
        for (int num : nums){
            String name = (String) dataModel.getRightTable().getData()[num][0];
            String reference = (String) dataModel.getRightTable().getReference()[num];
            dataModel.updateIntro(dataModel.getIntro() + name + reference + " have been selected\n");
        }

    }

    protected JPanel customizeLeftPanel(){
        JPanel jPanel = new JPanel(new GridBagLayout());
        jPanel.add(new JLabel("You need to add customized Left Panel here!"));
        return jPanel;
    }

    protected JPanel customizeRightPanel(){
        JPanel jPanel = new JPanel(new GridBagLayout());
        jPanel.add(new JLabel("You need to add customized Right Panel here!"));
        return jPanel;
    }

    public void addConnection(UIDataModel dataModel) {
        dataModel.addObserver(this.view);
    }
    private void addLeftTable(Table table) {
        view.getLeftTable().setModel(new DefaultTableModel(table.getData(), table.getColumnName()));
    }
    private void addRightTable(Table table) {
        view.getRightTable().setModel(new DefaultTableModel(table.getData(), table.getColumnName()));
    }

    /**
     * get the frame after build.
     * @return Integration frame
     */
    public Integration getView(){

        // Initialize the front data.
        initialization();
        view.setTitle(setFrameName());
        view.setNameLabel(setInfoTitle());
        view.getDetailLabel().setText(setIntro());
        view.getLeftButton().setText(setLeftButtonLabel());
        view.getRightButton().setText(setRightButtonLabel());
        addLeftTable(setLeftTable());
        addRightTable(setRightTable());

        // Plug in Buttons
        view.getLeftButton().addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                customizeLeftButton();
            }
        });
        view.getRightButton().addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                customizeRightButton();
            }
        });

        // Plug in customized Panels
        view.setLeftPanel(customizeLeftPanel());
        view.setRightPanel(customizeRightPanel());
        return view;
    }

    public UIDataModel getDataModel() {
        return dataModel;
    }



    //APIs for get the data in the GUI.

    public Object[][] getLeftSelectedColumns() {
        JTable jTable = view.getLeftTable();
        Object[][] result = new Object[jTable.getSelectedRowCount()][jTable.getColumnCount()];
        for (int i= 0; i < result.length; i ++) {
            result[i] = this.dataModel.getLeftTable().getData()[i];
        }
        return result;
    }
    public Object[][] getRightSelectedColumns() {
        JTable jTable = view.getRightTable();
        Object[][] result = new Object[jTable.getSelectedRowCount()][jTable.getColumnCount()];
        for (int i= 0; i < result.length; i ++) {
            result[i] = this.dataModel.getLeftTable().getData()[i];
        }
        return result;
    }



}
