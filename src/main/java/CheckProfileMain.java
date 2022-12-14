import controller.CheckProfileController;
import data_access.CheckProfileIMDataAccess;
import data_access.CheckProfileUserIDMap;
import entity.Curr;
import presenter.CheckProfilePresenter;
import use_case.check_profile_validation.CheckProfileIGateway;
import use_case.check_profile_validation.CheckProfileOutputBoundary;
import presenter.view_model.ViewModel;

public class CheckProfileMain {
    public static void main(String[] args) {
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(new ViewModel());
        CheckProfileController controller = new CheckProfileController(presenter, gateway);
        Curr.setUser(gateway.getUserByUid(CheckProfileUserIDMap.employee11Id));
        controller.create(CheckProfileUserIDMap.employee11Id, CheckProfileUserIDMap.employee11Id);
        presenter.showFrame();


    }
}
