package ui;


import controller.CompleteTaskController;
import data_access.CompleteTaskDataAccess;
import presenter.CompleteTaskPresenter;
import use_case.complete_task.CompleteTaskDsGateway;
import use_case.complete_task.CompleteTaskInputBoundary;
import use_case.complete_task.CompleteTaskInteractor;
import use_case.complete_task.CompleteTaskOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompleteTaskScreen {
    private JButton button_submit;
    private JPanel panelMain;
    CompleteTaskController controller;

    public CompleteTaskScreen() {
        button_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }


    public void viewScreen () {
        // make connection with use case
        CompleteTaskDataAccess gateway = new CompleteTaskDataAccess();
        CompleteTaskOutputBoundary presenter = new CompleteTaskPresenter();
        CompleteTaskInputBoundary interactor = new CompleteTaskInteractor(gateway, presenter);
        CompleteTaskController controller = new CompleteTaskController(interactor);

        CompleteTaskScreen completeScreen = new CompleteTaskScreen();
        // build GUI
        JFrame frame = new JFrame("Complete Page");
        frame.setContentPane(new CompleteTaskScreen().panelMain);

        frame.setMinimumSize(new Dimension(300, 300));
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
