package ui;

import controller.LoginController;
import login.LoginFailureResponseModel;
import login.LoginResponseModel;
import login.LoginSuccessResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer

public class LoginPromptScreen extends JPanel implements ActionListener {

    JTextField username = new JTextField(15);

    JPasswordField password = new JPasswordField(15);

    LoginController loginController;

    JPanel screens;

    CardLayout cardLayout;

    public LoginPromptScreen(LoginController loginController, JPanel screens, CardLayout cardLayout) {

        this.cardLayout = cardLayout;

        this.screens = screens;

        this.loginController = loginController;

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        JButton signUp = new JButton("Login");

        JPanel buttons = new JPanel();
        buttons.add(signUp);

        signUp.addActionListener(this);

        // this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        LoginResponseModel loginResponseModel = this.loginController.login(username.getText(),
                String.valueOf(password.getPassword()));

        if (loginResponseModel instanceof LoginSuccessResponseModel){}

        else if (loginResponseModel instanceof LoginFailureResponseModel){
            JPanel loginFailureScreen = new LoginFailureScreen((LoginFailureResponseModel) loginResponseModel);
            cardLayout.addLayoutComponent(loginFailureScreen, "loginFailureScreen");
            screens.add(loginFailureScreen);
            cardLayout.show(screens, "loginFailureScreen");
            System.out.println("here");
        }
    }
}