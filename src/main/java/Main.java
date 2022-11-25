import controller.LoginController;
import presenter.LoginPresenter;
import presenter.LoginResponseFormatter;
import ui.LoginScreen;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {


        JFrame application = new JFrame("Application");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        LoginPresenter loginPresenter = new LoginResponseFormatter();
        // LoginInputBoundary interactor = new LoginInteractor(loginPresenter, currentUser);
        // LoginController loginController = new LoginController(interactor);
        LoginController loginController = new LoginController();

        // TODO intialize data access

        // TODO pass data access to login interactor

        // TODO initialize feature interactors, controllers

        // Build the GUI, plugging in the parts
        JPanel loginScreen = new LoginScreen(loginController);
        screens.add(loginScreen, "welcome");
        cardLayout.show(screens, "login");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
