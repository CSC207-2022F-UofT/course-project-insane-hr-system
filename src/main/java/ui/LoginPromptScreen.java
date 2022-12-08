package ui;

import use_case.check_profile_validation.CheckProfileIGateway;
import use_case.check_profile_validation.CheckProfileOutputBoundary;
import controller.CheckProfileController;
import controller.LoginController;
import data_access.CheckProfileDataAccess;
import use_case.login.LoginFailureResponseModel;
import use_case.login.LoginResponseModel;
import use_case.login.LoginSuccessResponseModel;
import presenter.CheckProfilePresenter;
import presenter.view_model.ViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    public LoginPromptScreen(LoginController loginController, JPanel screens, CardLayout cardLayout) throws IOException {

        this.cardLayout = cardLayout;

        this.screens = screens;

        this.loginController = loginController;

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        JButton signUp = new JButton("Login");

        BufferedImage logo = ImageIO.read(new File("src/main/java/ui/logo.png"));
        Image scaledLogo = logo.getScaledInstance(150,75,Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));

        JPanel buttons = new JPanel();
        buttons.add(signUp);

        signUp.addActionListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(logoLabel);
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
            CheckProfileIGateway gateway = new CheckProfileDataAccess();
            CheckProfileOutputBoundary presenter = new CheckProfilePresenter(new ViewModel());
            CheckProfileController controller = new CheckProfileController(presenter, gateway);
            controller.create(userID, userID);
            presenter.showFrame();
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