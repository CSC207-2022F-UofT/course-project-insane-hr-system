package ui;

import presenter.view_model.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Integration extends JFrame implements PropertyChangeListener {
    private JPanel rootPanel;
    private JPanel InfoPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel nameLabel;
    private JTextArea detailLabel;
    private JTable leftTable;
    private JTable rightTable;
    private JPanel leftControllerPanel;
    private JPanel rightControllerPanel;
    private JButton leftButton;
    private JButton rightButton;


    public Integration(String frameName) {
        super(frameName);

    }
//    public Integration(String name, String detail, Table leftTable, Table rightTable, JPanel leftCustomizePanel, JPanel rightControllerPanel) {
//        super("HR system");
//        this.setContentPane(this.rootPanel);
//        this.nameLabel.setText(name);
//        this.detailLabel.setText(detail);
//        this.leftTable.setModel(new DefaultTableModel(leftTable.getData(), leftTable.getColumnName()));
//        this.rightTable.setModel(new DefaultTableModel(rightTable.getData(), rightTable.getColumnName()));
//        this.leftControllerPanel.add(leftCustomizePanel);
//        this.rightControllerPanel.add(rightControllerPanel);
//    }
//    public Integration(String name, String detail, Table leftTable, Table rightTable, UIDataModel dataModel) {
//        super("HR system");
//        this.setContentPane(this.rootPanel);
//        this.nameLabel.setText(name);
//        this.detailLabel.setText(detail);
//        this.leftTable.setModel(new DefaultTableModel(leftTable.getData(), leftTable.getColumnName()));
//        this.rightTable.setModel(new DefaultTableModel(rightTable.getData(), rightTable.getColumnName()));
//        this.dataModel = dataModel;
//    }
//    public Integration(String name, String detail, JPanel leftControllerPanel, JPanel rightControllerPanel) {
//        super("HR system");
//        this.setContentPane(this.rootPanel);
//        this.leftControllerPanel.add(leftControllerPanel);
//        this.rightControllerPanel.add(rightControllerPanel);
//        this.nameLabel.setText(name);
//        this.detailLabel.setText(detail);
//    }
//    public Integration(String name, String detail) {
//        super("HR system");
//        this.setContentPane(this.rootPanel);
//        this.nameLabel.setText(name);
//        this.detailLabel.setText(detail);
//    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setLeftControllerPanel(JPanel leftControllerPanel) {
        this.leftControllerPanel.add(leftControllerPanel);
    }

    public void setRightControllerPanel(JPanel rightControllerPanel) {
        this.rightControllerPanel.add(rightControllerPanel);
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(String nameTitle) {
        this.nameLabel.setText(nameTitle);
    }

    public void setDetailLabel(String nameTitle) {
        this.detailLabel.setText(nameTitle);
    }

    public JTextArea getDetailLabel() {
        return detailLabel;
    }

    public JButton getLeftButton() {
        return leftButton;
    }

    public JButton getRightButton() {
        return rightButton;
    }

    public JTable getLeftTable() {
        return leftTable;
    }

    public JTable getRightTable() {
        return rightTable;
    }

    public JPanel getLeftCustomizedPanel() {
        return leftControllerPanel;
    }

    public JPanel getRightCustomizedPanel() {
        return rightControllerPanel;
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("FrameNameChange")) {
            this.setTitle((String) evt.getNewValue());
        }else if (evt.getPropertyName().equals("TitleChange")) {
            this.nameLabel.setText((String) evt.getNewValue());
        }else if (evt.getPropertyName().equals("IntroChange")) {
            this.detailLabel.setText((String) evt.getNewValue());
        }else if (evt.getPropertyName().equals("LeftTableChange")) {
            Table table = ((Table) evt.getNewValue());
            this.leftTable.setModel(new DefaultTableModel(table.getData(), table.getColumnName()));
        }else if (evt.getPropertyName().equals("RightTableChange")) {
            Table table = ((Table) evt.getNewValue());
            this.rightTable.setModel(new DefaultTableModel(table.getData(), table.getColumnName()));
        }

    }


    public static void main(String[] args) {
        Integration frame = new Integration("HR system");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setNameLabel("name");
        frame.pack();
        frame.setVisible(true);
    }
}
