package ui;

import data_access.EvaluateTaskDataAccess;
import presenter.EvaluateTaskPresenter;
import use_case.evaluate_task.EvaluateTaskDsGateway;
import use_case.evaluate_task.EvaluateTaskInputBoundary;
import use_case.evaluate_task.EvaluateTaskInteractor;
import use_case.evaluate_task.EvaluateTaskOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluateTaskScreen {
    private JPanel panelMain;
    private JButton button_evaluate;
    private JTextField starField;
    private JTextField messageField;

    public EvaluateTaskScreen() {
        button_evaluate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panelMain, "Successfully Evaluated");
            }
        });
    }


    public void viewScreen() {
        EvaluateTaskDataAccess gateway = new EvaluateTaskDataAccess();
        EvaluateTaskOutputBoundary presenter = new EvaluateTaskPresenter();
        EvaluateTaskInputBoundary interactor = new EvaluateTaskInteractor(gateway, presenter);


        JFrame frame = new JFrame("Evaluate Page");
        frame.setContentPane(new EvaluateTaskScreen().panelMain);
        frame.setMinimumSize(new Dimension(400, 300));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
