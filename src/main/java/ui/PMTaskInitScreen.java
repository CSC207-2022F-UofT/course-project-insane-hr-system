package ui;

import controller.PMTaskInitController;
import data_access.PMTaskInitDataAccess;
import data_access.placeholderDataAccessClass;
import presenter.PMTaskInitPresenter;
import project_manager_task_init_use_case.PMTaskInitDsRequestModel;
import project_manager_task_init_use_case.PMTaskInitGateway;
import project_manager_task_init_use_case.PMTaskInitInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PMTaskInitScreen extends JPanel implements ActionListener {

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

        JButton createNewTask = new JButton("Create");

        JPanel buttons = new JPanel();
        buttons.add(createNewTask);

        createNewTask.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(taskNameInfo);
        this.add(taskDescriptionInfo);
        this.add(employeeIdInfo);
        this.add(buttons);

    }

    /**
     * make the buttons react to the action of clicking
     * @param evt the event to be processed
     */

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        taskInitController.create(taskName.getText(), taskDescription.getText(), Integer.parseInt(employeeId.getText()));

        JOptionPane.showMessageDialog(this, "Task created");
    }

    /**
     * generates the screen
     *
     */
    public static void main(String[] args) {
        PMTaskInitGateway gateway = new PMTaskInitDataAccess();
        PMTaskInitPresenter presenter = new PMTaskInitPresenter();
        PMTaskInitInteractor interactor = new PMTaskInitInteractor(presenter, gateway);
        PMTaskInitController controller = new PMTaskInitController(interactor);

        PMTaskInitScreen taskInitScreen = new PMTaskInitScreen(controller);

        JFrame frame = new JFrame("Initialize New Task");
        frame.setContentPane(taskInitScreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
