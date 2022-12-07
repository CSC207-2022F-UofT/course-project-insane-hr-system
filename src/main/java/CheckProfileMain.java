import check_profile_validation.*;
import controller.CheckProfileController;
import data_access.CheckProfileDataAccess;
import data_access.CheckProfileIMDataAccess;
import data_access.CheckProfileUserIDMap;
import entity.Curr;
import presenter.CheckProfilePresenter;
import presenter.IViewModel;
import ui.ScreenBuilder;
import view_model.Table;
import view_model.ViewModel;

import javax.swing.*;

public class CheckProfileMain {
//    public static void main(String[] args) {
//        ViewModel viewModel = new ViewModel();
//        CheckProfileIGateway gateway = new CheckProfileDataAccess();
//
//        ScreenBuilder screenBuilder = new ScreenBuilder(viewModel, gateway);
//
//        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
//
//        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway, presenter);
//        CheckProfileController controller = new CheckProfileController(interactor);
//        JFrame screen = screenBuilder.view();
//        screen.pack();
//        screen.setVisible(true);
//    }

    public static void main(String[] args) {
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(new ViewModel());
        CheckProfileController controller = new CheckProfileController(presenter, gateway);
        Curr.setUser(gateway.getUserByUid(CheckProfileUserIDMap.manager1Id));
        controller.create(CheckProfileUserIDMap.manager1Id, CheckProfileUserIDMap.manager1Id);
        presenter.showFrame();


    }
}
