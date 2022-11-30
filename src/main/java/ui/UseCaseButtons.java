package ui;

import presenter.UseCase;

import javax.swing.*;

public class UseCaseButtons {
    //TODO: Please create everyone's button here!
    public static JPanel getPanel(UseCase useCase, ScreenBuilder screenBuilder){
        switch (useCase){
            case SALARY_CALCULATOR:;
            case ENROLL_EMPLOYEE:;
            case CREATE_PROJECT:;
            case LEAVE_REQUEST:;
            case COMPLETE_TASK:;
            case CREATE_TASK:;
            case COMPLETE_PROJECT:;
        }
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("No Controller is allowed"));
        return jPanel;
    }

    static JPanel getUseCase1(ScreenBuilder screenBuilder){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("This is use case 1"));
        return jPanel;
    }
}
