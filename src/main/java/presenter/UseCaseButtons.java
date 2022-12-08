package presenter;

import controller.SalaryCalculatorController;
import entity.RelativeRelation;
import presenter.Controllers;
import salary_calculator.SalaryCalculator;
import salary_calculator.SalaryCalculatorInputBoundary;
import salary_calculator.SalaryCalculatorOutputBoundary;
import ui.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class UseCaseButtons {
    //TODO: Please create everyone's button here!
    //First create a new method that return your use case Panel, a button is preferred. I give getUseCase1 method as an example.
    //Then put your method into your cases. If you need more than one controller, please add your controller into enum Controllers first
    // and then add a case in this page.
    public static JPanel getPanel(Controllers controllers, ScreenBuilder screenBuilder){
        switch (controllers){
            case SALARY_CALCULATOR: return getSalaryCalculator(screenBuilder);
            case ENROLL_EMPLOYEE: return getEnrollEmploye();
            case CREATE_PROJECT:;
            case LEAVE_REQUEST: return getLeaveRequest(screenBuilder);
            case COMPLETE_TASK: return getCompleteTask(screenBuilder);
            case EVALUATE_TASK: return getEvaluateTask();
            case CREATE_TASK:;
            case COMPLETE_PROJECT:;
            case EXAMPLE_USE_CASE: return getUseCase1(screenBuilder);
            case APPROVE_LEAVE_TASK: return getApproveLeaveTask(screenBuilder);
        }
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("No Controller is allowed"));
        return jPanel;
    }

    private static JPanel getEnrollEmploye() {
        JPanel panel = new JPanel();
        JButton enrollButton = new JButton("Enroll Employee");
        panel.add(enrollButton);
        EnrollScreen enrollScreen = new EnrollScreen();
        enrollButton.addActionListener(e -> {
            enrollScreen.showScreenMain();

        });
        return panel;
    }

    private static JPanel getCompleteTask(ScreenBuilder screenBuilder) {
        JPanel panel = new JPanel();
        JButton completeButton = new JButton("Complete Task");
        panel.add(completeButton);
        CompleteTaskScreen completeTaskScreen = new CompleteTaskScreen();
        completeButton.addActionListener(e -> {
            UUID taskId = screenBuilder.getDataModel().getOid();
            completeTaskScreen.viewScreen();
        });
        return panel;
    }

    private static JPanel getEvaluateTask() {
        JPanel panel = new JPanel();
        JButton evaluateButton = new JButton("Evaluate Task");
        panel.add(evaluateButton);
        EvaluateTaskScreen evaluateTaskScreen = new EvaluateTaskScreen();
        evaluateButton.addActionListener(e -> {
        });
        return panel;
    }

    private static JPanel getSalaryCalculator(ScreenBuilder screenBuilder) {
        JPanel panel = new JPanel();
        JButton salaryButton = new JButton("Salary Calculator");
        panel.add(salaryButton);
        salaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Dialog");
                JOptionPane.showMessageDialog(frame, "This functionality has been cut");
            }
        });
        return panel;
    }

    public static JPanel getLeaveRequest(ScreenBuilder screenBuilder) {
        JPanel panel = new JPanel();
        JButton requestButton = new JButton("Leave Request");
        panel.add(requestButton);
        requestButton.addActionListener(e -> {
            LeaveRequestScreen ui = new LeaveRequestScreen(screenBuilder.view());
            ui.setVisible(true);
        });
        return panel;
    }

    public static JPanel getApproveLeaveTask(ScreenBuilder screenBuilder) {
        return new ReviewRequestScreen(screenBuilder.view(), screenBuilder.getDataModel().getOid());
    }

    public static JPanel getUseCase1(ScreenBuilder screenBuilder){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("No operator here"));
        return jPanel;
    }
}
