package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompleteTaskScreen {
    private JButton button_complete;
    private JPanel panelMain;
    private JTextField textField2;

    public CompleteTaskScreen() {
        button_complete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Complete Page");
        frame.setContentPane(new CompleteTaskScreen().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
