package ui;

import use_case.login.LoginFailureResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * the login failure screen
 */
public class LoginFailureScreen extends JPanel implements ActionListener{


    /**
     * constructs failure screen with failure message and try again button
     */
    public LoginFailureScreen(LoginFailureResponseModel loginFailureResponseModel) {



        JLabel title = new JLabel("Login Failed");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel message = new JLabel(loginFailureResponseModel.getMessage());
        message.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton tryAgainButton = new JButton("Try Again");
        JPanel buttons = new JPanel();
        buttons.add(tryAgainButton);

        tryAgainButton.addActionListener(this);

        // this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(message);
        this.add(buttons);
    }

    /**
     * react click of the try again button sending user back to login page
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        this.setVisible(false);
    }
}
