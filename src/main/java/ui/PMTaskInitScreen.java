package ui;

import controller.PMTaskInitController;
import data_access.PMTaskInitDataAccess;
import entity.*;
import entity.project.CommonProjectFactory;
import entity.project.Project;
import entity.role.Position;
import entity.role.Role;
import entity.role.RoleFactory;
import entity.task.Task;
import entity.user.CommonUserFactory;
import entity.user.User;
import presenter.PMTaskInitPresenter;
import use_case.project_manager_task_init_use_case.PMTaskInitGateway;
import use_case.project_manager_task_init_use_case.PMTaskInitInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

public class PMTaskInitScreen extends JPanel implements ActionListener {

    JTextField taskName = new JTextField(20);
    JTextField taskDescription = new JTextField(20);
    JTextField employeeId = new JTextField(20);
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
        this.add(taskNamePanel);
        this.add(taskDescriptionPanel);
        this.add(employeeIdPanel);
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
        Department department = new Department(UUID.randomUUID(), "Fake Department", 0, new HashSet<>(java.util.List.of(1)),
                "a fake department for testing", LocalDateTime.now());

        java.util.List<Role> pm_roles = Collections.singletonList(new RoleFactory().createCommonRole(Position.HEADOF, department));
        java.util.List<Project> pm_projects = new ArrayList<>();
        java.util.List<Task> pm_tasks = new ArrayList<>();

        User pm = new CommonUserFactory().create(0, department, "bio", "pmusername", "password", pm_roles, pm_projects, pm_tasks, Position.HEADOF, LocalDate.now());

        java.util.List<Role> employee_roles = Collections.singletonList(new RoleFactory().createCommonRole(Position.MEMBER, department));
        java.util.List<Project> employee_projects = new ArrayList<>();
        java.util.List<Task> employee_tasks = new ArrayList<>();

        User employee = new CommonUserFactory().create(1, department, "bio1", "employeeusername", "employeepassword", employee_roles, employee_projects, employee_tasks, Position.MEMBER, LocalDate.now());

        Curr.setUser(pm);

        Set<Integer> members = new HashSet<>();
        members.add(pm.getId());
        members.add(employee.getId());
        List<Task> tasks = new ArrayList<>();
        Project project = new CommonProjectFactory().createOpenProject("project1", members, "description", LocalDateTime.now(), department, tasks, 1);

        pm.addCurrProject(project);
        employee.addCurrProject(project);

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
