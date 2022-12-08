package ui;

import complete_task.*;
import controller.CompleteTaskController;
import data_access.CompleteTaskDataAccess;
import presenter.CompleteTaskPresenter;

import javax.swing.*;
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
        CompleteTaskDsGateway gateway = new CompleteTaskDataAccess();
        CompleteTaskOutputBoundary presenter = new CompleteTaskPresenter();
        CompleteTaskInputBoundary interactor = new CompleteTaskInteractor(gateway, presenter);
        CompleteTaskController controller = new CompleteTaskController(interactor);

        CompleteTaskScreen completeScreen = new CompleteTaskScreen();
        // build GUI
        JFrame frame = new JFrame("Complete Page");
        frame.setContentPane(new CompleteTaskScreen().panelMain);


        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
