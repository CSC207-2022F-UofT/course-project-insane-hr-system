package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompleteTaskUI {
    private JButton button_complete;
    private JPanel panelMain;
    private JTextField textField2;
    private JTextField textField3;

    public CompleteTaskUI() {
        button_complete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Complete Page");
        frame.setContentPane(new CompleteTaskUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
