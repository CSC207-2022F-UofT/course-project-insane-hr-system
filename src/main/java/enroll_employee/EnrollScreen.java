package enroll_employee;


import entity.CommonUserFactory;
import entity.UserFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollScreen {
    private JPanel EnrollPanel;
    private JPanel TopPanel;
    private JTextField nameField;
    private JComboBox<String> dptCom;
    private JButton Add;
    private JButton Cancel;
    private JComboBox<String> positionCom;
    private JPanel BottomPanel;

    private EnrollController enrollController;

    public EnrollScreen() {

        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fname = nameField.getText();
                String fdepartment = (String) dptCom.getSelectedItem();
                String fposition = (String) positionCom.getSelectedItem();
                EnrollResponseModel responseModel= enrollController.create(fname,fdepartment,fposition);
                newEmployeeScreen(responseModel);
            }
        });
    }
    public void newEmployeeScreen(EnrollResponseModel enrollResponseModel){
        JFrame frame2 = new JFrame("New Employee");
        frame2.setMinimumSize(new Dimension(450, 300));
        NewEmployeeScreen newEmployeeScreen = new NewEmployeeScreen();

        newEmployeeScreen.setEnrollResponseModel(enrollResponseModel);
        newEmployeeScreen.setInfo();

        newEmployeeScreen.showScreen(newEmployeeScreen,frame2);

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);
    }

    public void setEnrollController(EnrollController enrollController) {
        this.enrollController = enrollController;
    }

    public void showScreen(EnrollScreen enroll, JFrame frame) {
        frame.setContentPane(enroll.EnrollPanel);
    }

    public void setDptCom() {
        String[] dpts = enrollController.enrollInput.getAllDpts().toArray(new String[0]);
        //this.dptCom = new JComboBox(dpts);
        this.dptCom.setModel(new DefaultComboBoxModel<>(dpts));
    }

    public void setPositionCom() {
        this.positionCom.setModel(new DefaultComboBoxModel<>(new String[] { "Head", "Member" }));
    }

    public static void main(String[] args) {
        EnrollDsGateway dsGateway = new EnrollDataAccess();
        EnrollPresenter enrollPresenter = new EnrollResponseFormatter();
        UserFactory userFactory = new CommonUserFactory();
        EnrollInputBoundary interactor = new EnrollInteractor(dsGateway,enrollPresenter,userFactory);
        EnrollController enrollController = new EnrollController(interactor);

        // Build GUI

        JFrame frame = new JFrame("Enroll");
        frame.setMinimumSize(new Dimension(450, 300));
        EnrollScreen EnrollScreen = new EnrollScreen();

        EnrollScreen.setEnrollController(enrollController);
        EnrollScreen.setDptCom();
        EnrollScreen.setPositionCom();
        EnrollScreen.showScreen(EnrollScreen,frame);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
