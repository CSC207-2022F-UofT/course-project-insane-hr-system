package ui;

import javax.swing.*;

public class RootPanelFactory {

    public JPanel createRootPanel(String name, String detail, String[] leftColumn, Object[][] leftData, String[] rightColumn, Object[][] rightData, JPanel leftCustomizePanel, JPanel rightCustomizedPanel) {
        Integration integration = new Integration(name, detail, leftColumn, leftData, rightColumn, rightData, leftCustomizePanel, rightCustomizedPanel);
        return integration.getRootPanel();
    }
    public JPanel createRootPanel(String title, String intro, JPanel leftPanel, JPanel rightPanel) {
        Integration integration = new Integration(title, intro, leftPanel, rightPanel);
        return integration.getRootPanel();
    }

    public JPanel createBlankRootPanel(String title, String intro) {
        Integration  integration = new Integration(title, intro);
        return integration.getRootPanel();
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Integration");
        RootPanelFactory rootPanelFactory = new RootPanelFactory();
        JPanel rootPanel = rootPanelFactory.createBlankRootPanel("Leon", "This is Leon's introduction");
        frame.setContentPane(rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
