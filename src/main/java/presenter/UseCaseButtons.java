package presenter;

import controller.SalaryCalculatorController;
import controller.PMTaskInitController;
import data_access.PMTaskInitDataAccess;
import entity.RelativeRelation;
import presenter.Controllers;
import salary_calculator.SalaryCalculator;
import salary_calculator.SalaryCalculatorInputBoundary;
import salary_calculator.SalaryCalculatorOutputBoundary;
import project_manager_task_init_use_case.PMTaskInitGateway;
import project_manager_task_init_use_case.PMTaskInitInteractor;
import ui.LeaveRequestScreen;
import ui.PMTaskInitScreen;
import ui.ReviewRequestScreen;
import ui.SalaryView;
import ui.ScreenBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseCaseButtons {
    //TODO: Please create everyone's button here!
    //First create a new method that return your use case Panel, a button is preferred. I give getUseCase1 method as an example.
    //Then put your method into your cases. If you need more than one controller, please add your controller into enum Controllers first
    // and then add a case in this page.
    public static JPanel getPanel(Controllers controllers, ScreenBuilder screenBuilder){
        switch (controllers){
            case SALARY_CALCULATOR: return getSalaryCalculator(screenBuilder);
            case ENROLL_EMPLOYEE:;
            case CREATE_PROJECT:return getCreateProject(screenBuilder);
            case LEAVE_REQUEST: return getLeaveRequest(screenBuilder);
            case COMPLETE_TASK:;
            case CREATE_TASK: return getPMTaskInit();
            case COMPLETE_PROJECT:;
            case EXAMPLE_USE_CASE: return getUseCase1(screenBuilder);
            case APPROVE_LEAVE_TASK: return getApproveLeaveTask(screenBuilder);
            case RANK_EMPLOYEE:;
        }
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("No Controller is allowed"));
        return jPanel;
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

    public static JPanel getPMTaskInit() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Create New Task");
        panel.add(button);
        button.addActionListener(e -> {
            PMTaskInitGateway gateway = new PMTaskInitDataAccess();
            PMTaskInitPresenter presenter = new PMTaskInitPresenter();
            PMTaskInitInteractor interactor = new PMTaskInitInteractor(presenter, gateway);
            PMTaskInitController controller = new PMTaskInitController(interactor);

            PMTaskInitScreen taskInitScreen = new PMTaskInitScreen(controller);
            taskInitScreen.setVisible(true);
        });
        return panel;
    }

    public static JPanel getUseCase1(ScreenBuilder screenBuilder){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("No operator here"));
        return jPanel;
    }

    public static JPanel getCreateProject(ScreenBuilder screenBuilder){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("createProejct Not Implement"));
        return jPanel;
    }
}
