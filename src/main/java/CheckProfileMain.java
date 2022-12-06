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
//        Table left = new Table(new String[]{"Employee Name"}, new Object[][]{new Object[]{"Bob"}, new Object[]{"john"}}, new Object[]{11,22});
//        Table right = new Table(new String[]{"Head12 Name"}, new Object[][]{new Object[]{"Leon"}, new Object[]{"Alice"}}, new Object[]{11,22});
//        String intro = String.format("Introduction:\nUid:\t%s\n", 1);
//        IViewModel viewModel = new ViewModel(1, "Test Frame", "User Name", intro, left, right);
//        viewModel.setVisualLevel(VisualLevel.ONLY_FACE);
//        System.out.println(viewModel.toString());
//        ScreenBuilder screenBuilder = new ScreenBuilder(viewModel);
//        screenBuilder.show();
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(new ViewModel());
        CheckProfileController controller = new CheckProfileController(presenter, gateway);
        Curr.setUser(gateway.getUserByUid(CheckProfileUserIDMap.employee01Id));
        controller.create(CheckProfileUserIDMap.employee01Id, CheckProfileUserIDMap.employee01Id);
        presenter.showFrame();


    }
}
