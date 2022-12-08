package ui;

import use_case.enroll_employee.EnrollResponseModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class NewEmployeeScreen {
    private JPanel panel1;
    private JTextField idField;
    private JTextField userNameField;
    private JTextField passwordField;
    private JTextField timeField;
    private JTextField nameField1;

    private EnrollResponseModel enrollResponseModel;

    public void setEnrollResponseModel(EnrollResponseModel enrollResponseModel) {
        this.enrollResponseModel = enrollResponseModel;
    }

    public void showScreen(NewEmployeeScreen newEmployeeScreen, JFrame frame2) {
        frame2.setContentPane(newEmployeeScreen.panel1);
    }

    /**
     * put all the generated information into the screen.
     */

    public void setInfo() {
        nameField1.setText(enrollResponseModel.getName());
        idField.setText(enrollResponseModel.getId()+"");
        userNameField.setText(enrollResponseModel.getUsername());
        passwordField.setText(enrollResponseModel.getPassword());
        timeField.setText(enrollResponseModel.getCreationTime().toString());
    }

    public static void main(String[] args) {
        EnrollResponseModel enrollResponseModel = new EnrollResponseModel("Kelly Zhang", 10001, "zhan0001", "=user2022", LocalDate.now());
        JFrame frame2 = new JFrame("New Employee");
        frame2.setMinimumSize(new Dimension(450, 300));
        NewEmployeeScreen newEmployeeScreen = new NewEmployeeScreen();

        newEmployeeScreen.setEnrollResponseModel(enrollResponseModel);
        newEmployeeScreen.setInfo();

        newEmployeeScreen.showScreen(newEmployeeScreen,frame2);

        //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);
    }


}
