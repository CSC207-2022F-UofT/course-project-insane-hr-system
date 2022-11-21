package ui;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;

public class LeaveRequestUI extends JFrame {
    private JComboBox leaveTypeComboBox;
    private JTextPane messagePane;
    private JButton sendRequestButton;
    private JLabel leaveTypeLabel;
    private JLabel startDateLabel;
    private JLabel returnDateLabel;
    private JLabel messageLabel;

    private JPanel mainPanel;
    private DatePicker startDatePicker;
    private DatePicker returnDatePicker;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Leave Request");
        frame.setContentPane(new LeaveRequestUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
