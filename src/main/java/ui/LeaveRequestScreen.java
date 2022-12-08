package ui;

import com.github.lgooddatepicker.components.DatePicker;
import controller.LeaveRequestController;
import data_access.LeaveRequestDataAccess;
import entity.project.LeaveType;
import entity.project.ProjectBuilder;
import entity.project.LeaveRequestProjectBuilder;
import presenter.LeaveRequestPresenter;
import entity.Curr;
import use_case.leave_request.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaveRequestScreen extends JDialog implements ActionListener {
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
    JFrame frame;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public LeaveRequestScreen(JFrame frame) {
        super(frame, "Leave Request");
        LeaveRequestDsGateway gateway = new LeaveRequestDataAccess();
        LeaveRequestOutputBoundary presenter = new LeaveRequestPresenter();
        ProjectBuilder projectBuilder = new LeaveRequestProjectBuilder();
        LeaveRequestInputBoundary interactor = new LeaveRequestInteractor(gateway, presenter, projectBuilder);
        this.controller = new LeaveRequestController(interactor);
        this.frame = frame;
        initComponents();
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Test");
        panel.add(button);
        button.addActionListener(e -> {
            LeaveRequestScreen ui = new LeaveRequestScreen(frame);
            ui.setVisible(true);
        });
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
            LeaveRequestResponseModel response = controller.create(Curr.getUser(), messageArea.getText(), (LeaveType) leaveTypeComboBox.getSelectedItem(),
                    startDatePicker.getDate(), returnDatePicker.getDate());
            String message = "Your " + response.getLeaveType() + " leave request from " + response.getStartDate() + " to "
                    + response.getReturnDate() + " has been sent on " + response.getCreateTime() + ".";
            JOptionPane.showMessageDialog(this.frame, message, "Request Sent", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.frame, e.getMessage());
        }
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
        sendRequestButton.addActionListener(this);
    }
}
