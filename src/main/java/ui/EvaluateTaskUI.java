package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluateTaskUI {
    private JPanel panelMain;
    private JButton button_evaluate;
    private JTextField textField1;
    private JTextField textField2;

    public EvaluateTaskUI() {
        button_evaluate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Evaluate Page");
        frame.setContentPane(new EvaluateTaskUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
