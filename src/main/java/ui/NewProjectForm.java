package ui;

import controller.NewProjectController;
import use_case.create_new_project.NewProjectInputBoundary;
import use_case.create_new_project.NewProjectInteractor;

import javax.swing.*;

public class NewProjectForm {
    private JButton submitAndCreateProjectButton;
    private JPanel mainPanel;
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

    public NewProjectForm() {

        submitAndCreateProjectButton.addActionListener(e -> {
            int PMid = Integer.parseInt(PMidTextField.getText());
            int funds = Integer.parseInt(FundtextField.getText());
            String name = ProjNametextField.getText();
            String description = descriptextField.getText();
            String dpt = descriptextField.getText();
            controller.create(PMid, funds, name, description, dpt);
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Project");
        frame.setContentPane(new NewProjectForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
