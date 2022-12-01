package presenter;

import entity.RelativeRelation;
import presenter.Controllers;
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
            case ENROLL_EMPLOYEE:;
            case CREATE_PROJECT:;
            case LEAVE_REQUEST:;
            case COMPLETE_TASK:;
            case CREATE_TASK:;
            case COMPLETE_PROJECT:;
            case EXAMPLE_USE_CASE: return getUseCase1(screenBuilder);
        }
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("No Controller is allowed"));
        return jPanel;
    }



    public static JPanel getUseCase1(ScreenBuilder screenBuilder){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("This is use case 1"));
        return jPanel;
    }
}
