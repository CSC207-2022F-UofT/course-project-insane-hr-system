package ui;

import controller.PMTaskInitController;

import javax.swing.*;
import java.awt.*;

public class PMTaskInitScreen {

    JTextField taskName = new JTextField(50);
    JTextField taskDescription = new JTextField(50);
    JTextField employeeId = new JTextField(50);
    PMTaskInitController taskInitController;

    public PMTaskInitScreen(PMTaskInitController controller) {

        this.taskInitController = controller;

        JLabel title = new JLabel("Task Initialization");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel taskNameInfo = new JLabel("Name of the task: ");
        JLabel taskDescriptionInfo = new JLabel("Description: ");
        JLabel employeeIdInfo = new JLabel("ID of the employee to assign the task to: ");

        JPanel taskNamePanel = new JPanel();
        taskNamePanel.add(taskNameInfo);
        taskNamePanel.add(taskName);

        JPanel taskDescriptionPanel = new JPanel();
        taskDescriptionPanel.add(taskDescriptionInfo);
        taskDescriptionPanel.add(taskDescription);

        JPanel employeeIdPanel = new JPanel();
        employeeIdPanel.add(employeeIdInfo);
        employeeIdPanel.add(employeeId);


    }
}
