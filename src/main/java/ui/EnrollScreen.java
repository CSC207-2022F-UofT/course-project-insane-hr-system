package ui;


import controller.EnrollController;
import data_access.EnrollDataAccess;
import entity.user.CommonUserFactory;
import entity.user.UserFactory;
import presenter.EnrollPresenter;
import use_case.enroll_employee.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollScreen extends JPanel{

    // the screen that will be shown up when the CEO press the "enroll employee" button.
    private JPanel EnrollPanel;
    private JPanel TopPanel;
    private JTextField nameField;
    private JComboBox<String> dptCom;
    private JButton Add;
    private JComboBox<String> positionCom;
    private JPanel BottomPanel;

    private EnrollController enrollController;

    public EnrollScreen(){

        Add.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String fname = nameField.getText();
                String fdepartment = (String) dptCom.getSelectedItem();
                String fposition = (String) positionCom.getSelectedItem();
                EnrollResponseModel responseModel= enrollController.create(fname,fdepartment,fposition);
                newEmployeeScreen(responseModel);
                }catch (Exception evt){
                    JOptionPane.showMessageDialog(EnrollPanel, evt.getMessage());
                }
            }
        });

//        Cancel.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                EnrollPanel.
//            }
//        });

    }


    /**
     * Generate the screen that will contain the information of the new employee.
     * @param enrollResponseModel contains the generated userid, username, and user password.
     */
    public void newEmployeeScreen(EnrollResponseModel enrollResponseModel){
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

    public void setEnrollController(EnrollController enrollController) {
        this.enrollController = enrollController;
    }

    public void showScreen(EnrollScreen enroll, JFrame frame) {
        frame.setContentPane(enroll.EnrollPanel);
    }


    /**
     * put all the existing department names into the screen list.
     */
    public void setDptCom() {
        String[] dpts = enrollController.enrollInput.getAllDpts().toArray(new String[0]);
        //this.dptCom = new JComboBox(dpts);
        this.dptCom.setModel(new DefaultComboBoxModel<>(dpts));
    }


    /**
     * put the position options into the screen list.
     */

    public void setPositionCom() {
        this.positionCom.setModel(new DefaultComboBoxModel<>(new String[] { "HEAD", "MEMBER" }));
    }

    public void showScreenMain(){
        EnrollDsGateway dsGateway = new EnrollDataAccess();
        EnrollOutputBoundary enrollOutputBoundary = new EnrollPresenter();
        UserFactory userFactory = new CommonUserFactory();
        EnrollInputBoundary interactor = new EnrollInteractor(dsGateway, enrollOutputBoundary,userFactory);
        EnrollController enrollController = new EnrollController(interactor);

        // Build GUI

        JFrame frame = new JFrame("Enroll");
        frame.setMinimumSize(new Dimension(450, 300));
        EnrollScreen EnrollScreen = new EnrollScreen();

        EnrollScreen.setEnrollController(enrollController);
        EnrollScreen.setDptCom();
        EnrollScreen.setPositionCom();
        EnrollScreen.showScreen(EnrollScreen,frame);



        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getEnrollPanel() {
        return EnrollPanel;
    }
}
