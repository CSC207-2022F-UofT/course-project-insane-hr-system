package ui;

import create_new_project.NewProjectResponseModel;
import entity.Department;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Set;

public class NewProjectScreen extends JPanel {

    private JTextField ProjectManagerID;
    private JTextField name;
    private JTextField description;
    private JTextField funds;
    private JTextField dpt;
    JPanel j1, j2;
    JButton submit;

    private NewProjectResponseModel newProjectResponseModel;

    public NewProjectScreen() {
        this.ProjectManagerID = new JTextField();
        this.name = new JTextField();
        this.description = new JTextField();
        this.funds = new JTextField();
        this.dpt = new JTextField();

        j1 = new JPanel();
        j2 = new JPanel();

        j1.add(ProjectManagerID);
        j1.add(name);
        j1.add(description);
        j1.add(funds);
        j1.add(dpt);

        j2.add(submit);

        this.submit = new JButton("SUBMIT");
        this.add(submit, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        NewProjectScreen newscreen = new NewProjectScreen();
    }
}
