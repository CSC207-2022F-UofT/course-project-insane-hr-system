package ui;

import controller.LoginController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Frameworks/Drivers layer

public class LoginScreen extends JPanel implements ActionListener {

    JTextField username = new JTextField(15);

    JPasswordField password = new JPasswordField(15);

    LoginController loginController;

    public LoginScreen(LoginController loginController) throws IOException {

        this.loginController = loginController;

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        JButton signUp = new JButton("Login");

        BufferedImage logo = ImageIO.read(new File("ui/logo.png"));
        Image scaledLogo = logo.getScaledInstance(150,75,Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));

        JPanel buttons = new JPanel();
        buttons.add(signUp);

        signUp.addActionListener(this);

        // this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(logoLabel);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        this.loginController.login(username.getText(),
                String.valueOf(password.getPassword()));
    }
}