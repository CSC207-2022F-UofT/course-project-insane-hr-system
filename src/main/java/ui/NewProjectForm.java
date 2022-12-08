package ui;

import controller.NewProjectController;
import create_new_project.NewProjectInputBoundary;
import create_new_project.NewProjectInteractor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

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
        submitAndCreateProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int PMid = Integer.parseInt(PMidTextField.getText());
                int funds = Integer.parseInt(FundtextField.getText());
                String name = ProjNametextField.getText();
                String description = descriptextField.getText();
                String dpt = descriptextField.getText();
                controller.create(PMid, funds, name, description, dpt);
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
