package ui;

import com.github.lgooddatepicker.components.DatePicker;
import entity.LeaveType;

import javax.swing.*;
import java.awt.*;

public class LeaveRequestUI extends JFrame {
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

    public LeaveRequestUI() {
        initComponents();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Leave Request");
        frame.setContentPane(new LeaveRequestUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
