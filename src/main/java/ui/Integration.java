package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Integration {
    private JPanel rootPanel;
    private JPanel InfoPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel nameLabel;
    private JLabel detailLabel;
    private JTable leftTable;
    private JTable rightTable;
    private JPanel leftCustomizedPanel;
    private JPanel rightCustomizedPanel;


    public Integration() {
    }

    public Integration(String name, String detail, String[] leftColumn, Object[][] leftData, String[] rightColumn, Object[][] rightData, JPanel leftCustomizePanel, JPanel rightCustomizedPanel) {
        this.nameLabel.setText(name);
        this.detailLabel.setText(detail);
        this.leftTable.setModel(new DefaultTableModel(leftData, leftColumn));
        this.rightTable.setModel(new DefaultTableModel(rightData, rightColumn));
        this.leftCustomizedPanel.add(leftCustomizePanel);
        this.rightCustomizedPanel.add(rightCustomizedPanel);
    }

    public Integration(String name, String detail,JPanel leftCustomizedPanel, JPanel rightCustomizedPanel) {
        this.leftCustomizedPanel.add(leftCustomizedPanel);
        this.rightCustomizedPanel.add(rightCustomizedPanel);
        this.nameLabel.setText(name);
        this.detailLabel.setText(detail);
    }

    public Integration(String name, String detail) {
        this.nameLabel.setText(name);
        this.detailLabel.setText(detail);
    }
    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JPanel getInfoPanel() {
        return InfoPanel;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel.removeAll();
        this.leftPanel.add(leftPanel);
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel.removeAll();
        this.rightPanel.add(rightPanel);
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getDetailLabel() {
        return detailLabel;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Integration");
        frame.setContentPane(new Integration().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
