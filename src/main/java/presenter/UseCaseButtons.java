package presenter;

import ui.*;

import javax.swing.*;

public class UseCaseButtons {
    //TODO: Please create everyone's button here!
    //First create a new method that return your use case Panel, a button is preferred. I give getUseCase1 method as an example.
    //Then put your method into your cases. If you need more than one controller, please add your controller into enum Controllers first
    // and then add a case in this page.
    public static JPanel getPanel(Controllers controllers, ScreenBuilder screenBuilder){
        switch (controllers){
            case SALARY_CALCULATOR: return getSalaryCalculator();
            case ENROLL_EMPLOYEE: return getEnrollEmployee();
            case CREATE_PROJECT:return getCreateProject(screenBuilder);
            case LEAVE_REQUEST: return getLeaveRequest(screenBuilder);
            case COMPLETE_TASK: return getCompleteTask(screenBuilder);
            case EVALUATE_TASK: return getEvaluateTask();
            case CREATE_TASK:;
            case COMPLETE_PROJECT:;
            case EXAMPLE_USE_CASE: return getUseCase1();
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
        enrollButton.addActionListener(e -> enrollScreen.showScreenMain());
        return panel;
    }

    private static JPanel getCompleteTask(ScreenBuilder screenBuilder) {
        JPanel panel = new JPanel();
        JButton completeButton = new JButton("Complete Task");
        panel.add(completeButton);
        CompleteTaskScreen completeTaskScreen = new CompleteTaskScreen();
        completeButton.addActionListener(e -> {
            screenBuilder.getLeftSelectedRows();
            completeTaskScreen.viewScreen();
        });
        return panel;
    }

    private static JPanel getEvaluateTask() {
        JPanel panel = new JPanel();
        JButton evaluateButton = new JButton("Evaluate Task");
        panel.add(evaluateButton);
        EvaluateTaskScreen evaluateTaskScreen = new EvaluateTaskScreen();
        evaluateButton.addActionListener(e -> evaluateTaskScreen.viewScreen());
        return panel;
    }

    private static JPanel getSalaryCalculator() {
        JPanel panel = new JPanel();
        JButton salaryButton = new JButton("Salary Calculator");
        panel.add(salaryButton);
        salaryButton.addActionListener(e -> {
            JFrame frame = new JFrame("Dialog");
            JOptionPane.showMessageDialog(frame, "This functionality has been cut");
        });
        return panel;
    }

    public static JPanel getLeaveRequest(ScreenBuilder screenBuilder) {
        JPanel panel = new JPanel();
        JButton requestButton = new JButton("Leave Request");
        panel.add(requestButton);
        requestButton.addActionListener(e -> {
            LeaveRequestScreen ui = new LeaveRequestScreen(screenBuilder.getViewOnly());
            ui.setVisible(true);
        });
        return panel;
    }

    public static JPanel getApproveLeaveTask(ScreenBuilder screenBuilder) {
        return new ReviewRequestScreen(screenBuilder.getViewOnly(), screenBuilder.getDataModel().getOid());
    }

    public static JPanel getUseCase1(){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("No operator here"));
        return jPanel;
    }
    public static JPanel getCreateProject(ScreenBuilder screenBuilder) {
        JPanel panel = new JPanel();
        JButton createButton = new JButton("Create Project");
        panel.add(createButton);
        createButton.addActionListener(e -> {
            NewProjectForm ui = new NewProjectForm(screenBuilder.getViewOnly());
            ui.setContentPane(ui.mainPanel);
            ui.pack();
            ui.setVisible(true);
        });
        return panel;
    }
    public static JPanel getEnrollEmployee() {
            JPanel panel = new JPanel();
            JButton enrollButton = new JButton("Enroll Employee");
            panel.add(enrollButton);
            enrollButton.addActionListener(e -> {
                EnrollScreen ui = new EnrollScreen();
                ui.showScreenMain();
            });
            return panel;
    }
}

