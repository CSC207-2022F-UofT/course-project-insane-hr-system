package ui;

import controller.NewProjectController;
import use_case.create_new_project.NewProjectInputBoundary;
import use_case.create_new_project.NewProjectInteractor;

import javax.swing.*;

public class NewProjectForm extends JDialog {
    private JButton submitAndCreateProjectButton;
    public JPanel mainPanel;
    private JTextField PMidTextField;
    private JTextField ProjNametextField;
    private JTextField descriptextField;
    private JTextField FundtextField;
    private JTextField dpttextField;
    private JLabel projectManagerIDLabel;
    private JLabel projectNameLabel;
    private JLabel fundLabel;
    private JLabel descriptionLabel;
    private JLabel ddepartmentLabel;

    public final NewProjectInputBoundary projectInput = new NewProjectInteractor();
    public final NewProjectController controller = new NewProjectController(projectInput);

    public NewProjectForm(JFrame frame) {

        super(frame, "Create Project");
        submitAndCreateProjectButton.addActionListener(e -> {
            int PMid = Integer.parseInt(PMidTextField.getText());
            int funds = Integer.parseInt(FundtextField.getText());
            String name = ProjNametextField.getText();
            String description = descriptextField.getText();
            String dpt = dpttextField.getText();
            try {
                controller.create(PMid, funds, name, description, dpt);
                JOptionPane.showMessageDialog(frame, "Your project has been created!", "Project Created",
                        JOptionPane.PLAIN_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Project");
        frame.setContentPane(new NewProjectForm(frame).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
