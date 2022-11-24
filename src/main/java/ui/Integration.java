package ui;

import javax.swing.*;

public class Integration {
    private JPanel rootPanel;
    private JPanel InfoPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel nameLabel;
    private JLabel detailLabel;

    public Integration() {
    }

    public Integration(JPanel leftPanel, JPanel rightPanel, String name, String detail) {
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;
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

    public void setInfoPanel(JPanel infoPanel) {
        InfoPanel = infoPanel;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel = leftPanel;
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel = rightPanel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getDetailLabel() {
        return detailLabel;
    }

    public void setDetailLabel(JLabel detailLabel) {
        this.detailLabel = detailLabel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Integration");
        frame.setContentPane(new Integration().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
