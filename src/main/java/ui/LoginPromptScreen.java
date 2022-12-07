package ui;

import controller.CheckProfileController;
import controller.LoginController;
import login.LoginFailureResponseModel;
import login.LoginResponseModel;
import login.LoginSuccessResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer

/**
 * the login prompt screen
 */
public class LoginPromptScreen extends JPanel implements ActionListener {

    /**
     * username button label
     */
    JTextField username = new JTextField(15);

    /**
     * password button label
     */
    JPasswordField password = new JPasswordField(15);

    /**
     * the controller
     */
    LoginController loginController;

    /**
     * the screens container
     */
    JPanel screens;

    /**
     * the cardlayout
     */
    CardLayout cardLayout;

    /**
     * constructs a login screen with username, password text panels and login button
     */
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
     * reacts to login button click by attempting to log user in
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        LoginResponseModel loginResponseModel = this.loginController.login(username.getText(),
                String.valueOf(password.getPassword()));

        /**
         * present the userscreen
         */
        if (loginResponseModel instanceof LoginSuccessResponseModel){
            int userID = ((LoginSuccessResponseModel) loginResponseModel).getUserID();
            CheckProfileController checkProfileController = new CheckProfileController();
            checkProfileController.create(userID, userID);
        }

        /**
         * present the login failure screen
         */
        else if (loginResponseModel instanceof LoginFailureResponseModel){
            JPanel loginFailureScreen = new LoginFailureScreen((LoginFailureResponseModel) loginResponseModel);
            cardLayout.addLayoutComponent(loginFailureScreen, "loginFailureScreen");
            screens.add(loginFailureScreen);
            cardLayout.show(screens, "loginFailureScreen");
            System.out.println("here");
        }
    }
}