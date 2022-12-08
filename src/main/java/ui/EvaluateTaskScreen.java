package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluateTaskScreen {
    private JPanel panelMain;
    private JButton button_evaluate;
    private JTextField textField1;
    private JTextField textField2;

    public EvaluateTaskScreen() {
        button_evaluate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Evaluate Page");
        frame.setContentPane(new EvaluateTaskScreen().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
