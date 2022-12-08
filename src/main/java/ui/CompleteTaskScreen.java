package ui;

import complete_task.CompleteTaskDsGateway;
import complete_task.CompleteTaskInputBoundary;
import complete_task.CompleteTaskInteractor;
import complete_task.CompleteTaskOutputBoundary;
import controller.CompleteTaskController;
import data_access.CompleteTaskDataAccess;
import presenter.CompleteTaskPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompleteTaskScreen {
    private JButton button_complete;
    private JPanel panelMain;
    private JTextField textField2;

    public CompleteTaskScreen() {
        button_complete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public static void main(String[] args) {
        // make connection with use case
        CompleteTaskDsGateway gateway = new CompleteTaskDataAccess();
        CompleteTaskOutputBoundary presenter = new CompleteTaskPresenter();
        CompleteTaskInputBoundary interactor = new CompleteTaskInteractor(gateway, presenter);
        CompleteTaskController controller = new CompleteTaskController(interactor);

        // build GUI
        JFrame frame = new JFrame("Complete Page");
        frame.setContentPane(new CompleteTaskScreen().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
