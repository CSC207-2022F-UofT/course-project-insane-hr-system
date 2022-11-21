package ui;

import com.github.lgooddatepicker.components.DatePicker;
import entity.LeaveType;

import javax.swing.*;
import java.awt.*;

public class LeaveRequestUI extends JFrame {
    private JComboBox<LeaveType> leaveTypeComboBox;
    private JTextArea messageArea;
    private JButton sendRequestButton;
    private JLabel leaveTypeLabel;
    private JLabel startDateLabel;
    private JLabel returnDateLabel;
    private JLabel messageLabel;
    private JPanel mainPanel;
    private DatePicker startDatePicker;
    private DatePicker returnDatePicker;

    public LeaveRequestUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        leaveTypeLabel = new JLabel("Leave Type:");
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(leaveTypeLabel, c);

        leaveTypeComboBox = new JComboBox<>(LeaveType.values());
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(leaveTypeComboBox, c);

        startDateLabel = new JLabel("Start Date:");
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(startDateLabel, c);

        startDatePicker = new DatePicker();
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(startDatePicker, c);

        returnDateLabel = new JLabel("Return Date:");
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(returnDateLabel, c);

        returnDatePicker = new DatePicker();
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(returnDatePicker, c);

        messageLabel = new JLabel("Message:");
        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(messageLabel, c);

        messageArea = new JTextArea();
        messageArea.setLineWrap(true);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.ipady = 50;
        mainPanel.add(messageArea, c);

        sendRequestButton = new JButton("Send Request");
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 4;
        c.weightx = 0;
        c.weighty = 0;
        c.ipady = 0;
        mainPanel.add(sendRequestButton, c);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Leave Request");
        frame.setContentPane(new LeaveRequestUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
