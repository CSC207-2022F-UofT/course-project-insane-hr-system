package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Frameworks/Drivers layer

public class LoginScreen extends JFrame implements ActionListener {

    /**
     * A window with a title and a JButton.
     */
    public LoginScreen() {

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton logIn = new JButton("Log in");

        JPanel buttons = new JPanel();
        buttons.add(logIn);

        logIn.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);
        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}