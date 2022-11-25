package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
public abstract class IntegrationBuilder {
    private final UIDataModel dataModel;
    private final Integration view = new Integration();

    public IntegrationBuilder(UIDataModel dataModel) {

        this.dataModel = dataModel;
        this.dataModel.addObserver(view);

    }

    public UIDataModel getDataModel() {
        return dataModel;
    }

    public void initialization(){
//        try {
//            view.setIconImage(ImageIO.read(new File("java/ui/logo.png")));
//        } catch (IOException e) {
//            throw new RuntimeException("Didn't find Logo!", e);
//        }
    }

    public Integration getView(){

        // Initialize the front data.
        initialization();
        view.setTitle(setFrameName());
        view.setNameLabel(setInfoTitle());
        view.getDetailLabel().setText(setIntro());
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

//        // Plug in customized Panel
        view.setLeftPanel(customizeLeftPanel());
        view.setRightPanel(customizeRightPanel());
        return view;
    }


    public void addConnection(UIDataModel dataModel) {
        dataModel.addObserver(this.view);
    }
    protected void addLeftTable(Table table) {
        view.getLeftTable().setModel(new DefaultTableModel(table.getData(), table.getColumnName()));
    }
    protected void addRightTable(Table table) {
        view.getRightTable().setModel(new DefaultTableModel(table.getData(), table.getColumnName()));
    }
    protected Table setLeftTable() {
        return new Table(new String[]{"Left Table need to be override!"}, new Object[][]{new Object[]{"Leon"}, new Object[]{"Alice"}}, new Object[]{10,20});
    }

    protected Table setRightTable(){
        return new Table(new String[]{"Right Table need to be override!"}, new Object[][]{new Object[]{"Leon"}, new Object[]{"Alice"}}, new Object[]{10,20});
    }

    protected void customizeLeftButton(){

        JOptionPane.showMessageDialog(view,
                "Left button haven't customized",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);
    }

    protected void customizeRightButton(){
        Object[][] table = getRightSelectedColumns();
        int[] nums = view.getRightTable().getSelectedRows();
        for (int num : nums){
            String name = (String) dataModel.getRightTable().getData()[num][0];
            dataModel.updateIntro(dataModel.getIntro() + name + " have been selected\n");
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



    protected String setIntro() {
        return "IntegrationIntro";
    }

    protected String setInfoTitle() {
        return "Integration ObjectName";
    }

    protected String setFrameName() {
        return "IntegrationFrameName";
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
