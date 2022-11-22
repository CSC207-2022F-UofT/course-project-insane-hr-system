package ui;

import com.github.lgooddatepicker.components.DatePicker;
import controller.LeaveRequestController;
import entity.Curr;
import entity.LeaveRequestProjectBuilder;
import entity.LeaveType;
import entity.ProjectBuilder;
import leave_request.*;
import presenter.LeaveRequestPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaveRequestUI extends JFrame implements ActionListener {
    private JPanel mainPanel;
    JComboBox<LeaveType> leaveTypeComboBox = new JComboBox<>(LeaveType.values());
    JTextArea messageArea = new JTextArea();
    JButton sendRequestButton = new JButton("Send Request");
    JLabel leaveTypeLabel = new JLabel("Leave Type:");
    JLabel startDateLabel = new JLabel("Start Date:");
    JLabel returnDateLabel = new JLabel("Return Date:");
    JLabel messageLabel = new JLabel("Message:");
    DatePicker startDatePicker = new DatePicker();
    DatePicker returnDatePicker = new DatePicker();
    LeaveRequestController controller;

    public LeaveRequestUI() {
//        this.controller = controller;
        initComponents();
        sendRequestButton.addActionListener(this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Leave Request");

//        LeaveRequestDsGateway gateway;
//        LeaveRequestOutputBoundary outputBoundary = new LeaveRequestPresenter();
//        ProjectBuilder projectBuilder = new LeaveRequestProjectBuilder();
//        LeaveRequestInputBoundary interactor = new LeaveRequestInteractor(gateway, outputBoundary, projectBuilder);
//        LeaveRequestController controller = new LeaveRequestController(interactor);

        frame.setContentPane(new LeaveRequestUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
//            LeaveRequestResponseModel response = controller.create(Curr.getUser(), messageArea.getText(), (LeaveType) leaveTypeComboBox.getSelectedItem(),
//                    startDatePicker.getDate(), returnDatePicker.getDate());
            JOptionPane.showMessageDialog(this, " Request sent.", "SENT REQUEST", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private JPanel getPanel() {
        return mainPanel;
    }

    private void initComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(leaveTypeLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(leaveTypeComboBox, c);

        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(startDateLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(startDatePicker, c);

        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(returnDateLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(returnDatePicker, c);

        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(messageLabel, c);

        messageArea.setLineWrap(true);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.ipady = 50;
        mainPanel.add(messageArea, c);

        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 4;
        c.weightx = 0;
        c.weighty = 0;
        c.ipady = 0;
        mainPanel.add(sendRequestButton, c);
    }
}
