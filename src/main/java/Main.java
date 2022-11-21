import controller.LoginController;
import entity.Curr;
import login.LoginInputBoundary;
import login.LoginInteractor;
import presenter.LoginPresenter;
import ui.LoginScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        Curr currentUser = new Curr();

        JFrame application = new JFrame("Application");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        LoginPresenter loginScreen = new LoginReponseFormatter();
        LoginInputBoundary interactor = new LoginInteractor(currentUser, loginScreen);
        LoginController loginController = new LoginController(interactor);

        // TODO intialize data access

        // TODO pass data access to login interactor

        // TODO initialize feature interactors, controllers

        // Build the GUI, plugging in the parts
        LoginScreen loginScreen = new LoginScreen(userRegisterController);
        screens.add(loginScreen, "welcome");
        cardLayout.show(screens, "login");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
