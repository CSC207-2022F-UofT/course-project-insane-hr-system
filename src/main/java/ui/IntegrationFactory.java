package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegrationFactory {

    public Integration createRootPanel(String name, String detail, Table leftTable, Table rightTable, JPanel leftCustomizePanel, JPanel rightCustomizedPanel) {
        Integration integration = new Integration(name, detail, leftTable, rightTable, leftCustomizePanel, rightCustomizedPanel);
        return buttonSetUp(integration);
    }
    public Integration createRootPanel(String title, String intro, JPanel leftPanel, JPanel rightPanel) {
        Integration integration = new Integration(title, intro, leftPanel, rightPanel);
        return buttonSetUp(integration);
    }

    public Integration createBlankRootPanel(String title, String intro) {
        Integration  integration = new Integration(title, intro);
        return buttonSetUp(integration);
    }
    public Integration createByDataModel(UIDataModel dataModel){
        return new Integration(dataModel.getInfoTitle(), dataModel.getIntro(),dataModel.getLeftTable(), dataModel.getRightTable(), dataModel);
    }

    private Integration buttonSetUp(Integration integration) {
        integration.getLeftButton().addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedColumns = integration.getLeftTable().getSelectedColumns();
                integration.getDetailLabel().setText(integration.getDetailLabel().getText() + "A left click occur");
            }
        });
        integration.getRightButton().addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                integration.getDetailLabel().setText(integration.getDetailLabel().getText() + "A right click occur");
            }
        });
        return integration;
    }


    public static void main(String[] args) {
        IntegrationFactory integrationFactory = new IntegrationFactory();
        JFrame frame = integrationFactory.createBlankRootPanel("Leon", "This is Leon's introduction");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
