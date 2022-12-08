package use_case.check_profile_validation;

import use_case.check_profile_validation.*;
import controller.CheckProfileController;
import data_access.CheckProfileIMDataAccess;
import data_access.CheckProfileUserIDMap;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presenter.CheckProfilePresenter;
import presenter.IViewModel;
import presenter.view_model.ViewModel;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CheckProfileInteractorTest {


    @BeforeEach
    void setUp() {
        Curr.setUser(new CommonUser(10));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkUserProfile() {
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        System.out.println(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        controller.create(CheckProfileUserIDMap.employee01Id,CheckProfileUserIDMap.employee01Id);
        System.out.println(viewModel);

    }

    @Test
    void checkVisualLevel() {
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(CheckProfileUserIDMap.employee01Id,CheckProfileUserIDMap.employee01Id));
        System.out.println(responseModel);
        assertEquals(responseModel.getVisualLevel(), VisualLevel.EDITABLE);
        assertEquals(responseModel.getRelation(), RelativeRelation.IS_EMPLOYEE_SELF);
    }

    @Test
     void checkEeSeeEeInSameProject() {
        Integer requester = CheckProfileUserIDMap.employee01Id;
        Integer target = CheckProfileUserIDMap.employee21Id;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(responseModel.getVisualLevel(), VisualLevel.PROFILE);
        assertEquals(responseModel.getRelation(), RelativeRelation.NO_RELATION);
    }

    @Test
    void checkEeSeeEeInDiffProject() {
        Integer requester = CheckProfileUserIDMap.employee11Id;
        Integer target = CheckProfileUserIDMap.employee21Id;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(responseModel.getVisualLevel(), VisualLevel.PROFILE);
        assertEquals(responseModel.getRelation(), RelativeRelation.NO_RELATION);
    }


    @Test
    void checkPMSeeEeInSameProject() {
        Integer requester = CheckProfileUserIDMap.manager1Id;
        Integer target = CheckProfileUserIDMap.employee11Id;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(VisualLevel.EDITABLE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.IS_P_M_OF, responseModel.getRelation());
    }
    @Test
    void checkPMSeeEeInSameProject2() {
        Integer requester = CheckProfileUserIDMap.manager1Id;
        Integer target = CheckProfileUserIDMap.employee01Id;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(VisualLevel.EDITABLE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.IS_P_M_OF, responseModel.getRelation());
    }

    @Test
    void checkPMSeeEeInDiffProject() {
        Integer requester = CheckProfileUserIDMap.manager1Id;
        Integer target = CheckProfileUserIDMap.employee21Id;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(VisualLevel.PROFILE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.NO_RELATION, responseModel.getRelation());
    }

    @Test
    void checkDptHeadSeeEe() {
        Integer requester = CheckProfileUserIDMap.headId;
        Integer target = CheckProfileUserIDMap.employee11Id;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(VisualLevel.EDITABLE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.IS_DPT_HEAD_OF, responseModel.getRelation());
    }

    @Test
    void checkDptHeadSeePM() {
        Integer requester = CheckProfileUserIDMap.headId;
        Integer target = CheckProfileUserIDMap.manager1Id;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(VisualLevel.EDITABLE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.IS_DPT_HEAD_OF, responseModel.getRelation());
    }

    @Test
    void checkDptHeadSeeDpt() {
        Integer requester = CheckProfileUserIDMap.headId;
        Integer target = CheckProfileUserIDMap.headId;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(VisualLevel.EDITABLE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.IS_DPT_HEAD_SELF, responseModel.getRelation());
    }

    @Test
    void checkSeePMSelf() {
        Integer requester = CheckProfileUserIDMap.manager1Id;
        Integer target = CheckProfileUserIDMap.manager1Id;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(VisualLevel.EDITABLE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.IS_PM_SELF, responseModel.getRelation());
    }

    @Test
    void checkEeSeeSelf() {
        Integer requester = CheckProfileUserIDMap.employee01Id;
        Integer target = CheckProfileUserIDMap.employee01Id;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(VisualLevel.EDITABLE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.IS_EMPLOYEE_SELF, responseModel.getRelation());
    }

    @Test
    void checkEeSeeDptHead() {
        Integer requester = CheckProfileUserIDMap.employee11Id;
        Integer target = CheckProfileUserIDMap.headId;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(VisualLevel.ONLY_FACE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.NO_RELATION, responseModel.getRelation());
    }

    @Test
    void checkEeSeePM() {
        Integer requester = CheckProfileUserIDMap.employee11Id;
        Integer target = CheckProfileUserIDMap.manager1Id;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(VisualLevel.ONLY_FACE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.NO_RELATION, responseModel.getRelation());
    }
    @Test
    void checkEeSeeOtherPM() {
        Integer requester = CheckProfileUserIDMap.employee11Id;
        Integer target = CheckProfileUserIDMap.manager2Id;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkUserProfile(new CheckUserFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getUserByUid(target).toString());
        assertEquals(VisualLevel.PROFILE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.NO_RELATION, responseModel.getRelation());
    }

    @Test
    void checkEeSeeProject() {
        Integer requester = CheckProfileUserIDMap.employee11Id;
        UUID target = CheckProfileUserIDMap.project1UUID;
        CheckProfileIGateway gateway = new CheckProfileIMDataAccess();

        IViewModel viewModel = new ViewModel();
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(viewModel);
        CheckProfileInputBoundary interactor = new CheckProfileInteractor(gateway,presenter);
        CheckProfileController controller = new CheckProfileController(interactor);
        CheckProfileResponseModel responseModel = interactor.checkOrgProfile(new CheckOrgFileRequestModel(requester,target));
        System.out.println(gateway.getUserByUid(requester).toString() + '\n' + gateway.getOrgByOid(target).toString());
        assertEquals(VisualLevel.EDITABLE, responseModel.getVisualLevel());
        assertEquals(RelativeRelation.IS_MEMBER_OF, responseModel.getRelation());
    }

    @Test
    void checkOrgProfile() {
    }

    @Test
    void setTables() {
    }

    @Test
    void getOrgnizations() {
    }

    @Test
    void getUncommonOrgnizations() {
    }
}