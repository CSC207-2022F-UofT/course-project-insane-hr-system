package presenter;

import check_profile_validation.*;
import entity.RelativeRelation;
import view_model.*;

import java.util.LinkedList;
import java.util.List;

public class CheckProfilePresenter implements CheckProfileOutputBoundary {
    private UIDataModel dataModel;
    private UserIViewModel userIViewModel;
    private OrgIViewModel orgIViewModel;

    public CheckProfilePresenter() {
    }

    public CheckProfilePresenter(UIDataModel dataModel, UserIViewModel userIViewModel, OrgIViewModel orgIViewModel) {
        this.dataModel = dataModel;
        this.userIViewModel = userIViewModel;
        this.orgIViewModel = orgIViewModel;
    }

    public void initialSetup(CheckProfileResponseModel responseModel, IViewModel viewModel) {
        responseModel.getGateway().addObserver(dataModel);
        viewModel.setFrameName("HR system - " + responseModel.getFileType());
        viewModel.setInfoTitle(responseModel.getName());
        viewModel.setIntro(responseModel.getBio());
        viewModel.setLeftTable(getLeftTable(responseModel));
        viewModel.setRightTable(getRightTable(responseModel));
        viewModel.setVisualLevel(responseModel.getVisualLevel());
        viewModel.setFunction(getFunctions(responseModel.getRelation()));
    }
    @Override
    public void prepareUserFrame(CheckProfileResponseModel responseModel) {

        //TODO: getBuilder is not yet finished
        initialSetup(responseModel, userIViewModel);
        userIViewModel.setUid(responseModel.getUid());
//        if (responseModel.getVisualLevel() == VisualLevel.INVISIBLE) {
//            show(screenBuilder.getNotVisible());
//        }else if (responseModel.getVisualLevel() == VisualLevel.ONLY_FACE) {
//            show(screenBuilder.getIntroOnly());
//        }else if (responseModel.getVisualLevel() == VisualLevel.PROFILE) {
//            show(screenBuilder.getIntroAndTable());
//        }else if (responseModel.getVisualLevel() == VisualLevel.EDITABLE) {
//            FrameFactoryInt factory = new FrameFactory();
////            factory.create(ScreenType.)
//            //TODO move to frame layer
//            show(screenBuilder.getIntroTableAndButton());
//        }
//        show(screenBuilder.getNotVisible());
    }

    @Override
    public void prepareOrgFrame(CheckProfileResponseModel responseModel) {
        initialSetup(responseModel, orgIViewModel);
        orgIViewModel.setOid(responseModel.getOid());

//TODO
    }
    private Function[] getFunctions(RelativeRelation relation) {
        List<Function> functions = new LinkedList<>();

        for (Function function : Function.values()) {
            if (functionIsInNeed(function, relation)) {
                functions.add(function);
            }
        }
        return functions.toArray(new Function[0]);
    }

    private boolean functionIsInNeed(Function function, RelativeRelation relation) {
        switch (function) {
            case CREATE_TASK: return relation == RelativeRelation.IS_P_M_OF;
            case LEAVE_REQUEST: return relation == RelativeRelation.IS_EMPLOYEE_SELF;
            case CREATE_PROJECT:return relation == RelativeRelation.IS_DPT_HEAD_SELF;
            case ENROLL_EMPLOYEE: return relation == RelativeRelation.IS_DPT_HEAD_SELF;
            case SALARY_CALCULATOR: return relation == RelativeRelation.IS_EMPLOYEE_SELF || relation == RelativeRelation.IS_PM_SELF;
            case COMPLETE_PROJECT: return relation == RelativeRelation.IS_HEAD_OF;
            case COMPLETE_TASK: return relation == RelativeRelation.IS_MEMBER_OF;

        }
        return false;
    }


//    public ScreenBuilder createScreenBuilder(CheckProfileResponseModel responseModel) {
//        if (responseModel.getFileType() == FileType.DEPARTMENT_FILE) {
//            return createDptScreenBuilder(responseModel);
//        } else if (responseModel.getFileType() == FileType.PROJECT_FILE) {
//            return createProjectScreenBuilder(responseModel);
//        } else if (responseModel.getFileType() == FileType.TASK_FILE) {
//            return createTaskScreenBuilder(responseModel);
//        } else if (responseModel.getFileType() == FileType.USER_FILE) {
//            return createUserScreenBuilder(responseModel);
//        }
//        return null;
//    }

//    public UserDataModel createUserDataModel(CheckProfileResponseModel responseModel) {
//        Table leftTable = getLeftTable(responseModel);
//
//        Table rightTable = getRightTable(responseModel);
//
//        return new UserDataModel(responseModel.getUid(),
//                "User File",
//                "This is ",
//                responseModel.getName() + "'s bio:\n" + responseModel.getBio(),
//                leftTable,
//                rightTable);
//    }
//
//    public OrgDataModel createOrgDataModel(CheckProfileResponseModel responseModel) {
//        Table leftTable = getLeftTable(responseModel);
//
//        Table rightTable = getRightTable(responseModel);
//
//        return new OrgDataModel(responseModel.getOid(),
//                "Organization File",
//                "This is ",
//                responseModel.getName() + "'s introduction:\n" + responseModel.getBio(),
//                leftTable,
//                rightTable);
//    }

    private Table getLeftTable(CheckProfileResponseModel responseModel) {
        String[] columnName = new String[1];
        columnName[0] = responseModel.getList1Name();
        Object[][] list = new Object[responseModel.getList1().size()][1];

        return new Table(columnName, list, responseModel.getReference1());
    }
    private Table getRightTable(CheckProfileResponseModel responseModel) {
        String[] columnName = new String[1];
        columnName[0] = responseModel.getList2Name();
        Object[][] list = new Object[responseModel.getList2().size()][1];

        return new Table(columnName, list, responseModel.getReference2());
    }


    @Override
    public void update() {
//TODO
    }
//
//    private void show(JFrame frame) {
//        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }

}
