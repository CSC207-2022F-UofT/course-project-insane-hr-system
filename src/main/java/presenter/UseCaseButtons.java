package presenter;

import entity.RelativeRelation;
import presenter.Controllers;
import ui.EnrollScreen;
import ui.LeaveRequestScreen;
import ui.ReviewRequestScreen;
import ui.ScreenBuilder;

import javax.swing.*;

public class UseCaseButtons {
    //TODO: Please create everyone's button here!
    //First create a new method that return your use case Panel, a button is preferred. I give getUseCase1 method as an example.
    //Then put your method into your cases. If you need more than one controller, please add your controller into enum Controllers first
    // and then add a case in this page.
    public static JPanel getPanel(Controllers controllers, ScreenBuilder screenBuilder){
        switch (controllers){
            case SALARY_CALCULATOR:;
            case ENROLL_EMPLOYEE: return getEnrollEmployee();
            case CREATE_PROJECT:;
            case LEAVE_REQUEST: return getLeaveRequest(screenBuilder);
            case COMPLETE_TASK:;
            case CREATE_TASK:;
            case COMPLETE_PROJECT:;
            case EXAMPLE_USE_CASE: return getUseCase1(screenBuilder);
            case APPROVE_LEAVE_TASK: return getApproveLeaveTask(screenBuilder);
        }
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("No Controller is allowed"));
        return jPanel;
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
        jPanel.add(new JLabel("This is use case 1"));
        return jPanel;
    }

    public static JPanel getEnrollEmployee(){
        return new EnrollScreen().getEnrollPanel();
    }
}
