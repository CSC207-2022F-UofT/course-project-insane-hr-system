package presenter;

import entity.Curr;
import entity.Organization;
import entity.user.User;
import presenter.view_model.ScreenType;
import presenter.view_model.Table;
import presenter.view_model.ViewModel;
import ui.ScreenBuilder;
import use_case.check_profile_validation.CheckProfileOutputBoundary;
import use_case.check_profile_validation.CheckProfileResponseModel;

public class CheckProfilePresenter implements CheckProfileOutputBoundary {
    private IViewModel viewModel = new ViewModel();

    public CheckProfilePresenter(){
    }

    public CheckProfilePresenter(IViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareUserFrame(CheckProfileResponseModel responseModel) {

        initialSetup(responseModel, viewModel);
        viewModel.setUid(responseModel.getTargetUid());


    }

    @Override
    public void prepareOrgFrame(CheckProfileResponseModel responseModel) {
        initialSetup(responseModel, viewModel);
        viewModel.setOid(responseModel.getTargetOid());
//        ScreenBuilder screenBuilder = new ScreenBuilder(this.viewModel);
//        screenBuilder.show();
//TODO
    }

    @Override
    public void showFrame(){
        ScreenBuilder screenBuilder = new ScreenBuilder(this.viewModel);
        System.out.println(viewModel);
        screenBuilder.show();
    }
    public void initialSetup(CheckProfileResponseModel responseModel, IViewModel viewModel) {
        responseModel.getGateway().addObserver(viewModel);
        viewModel.setRequesterID(Curr.getUser().getId());
        viewModel.setFrameName("HR system - " + responseModel.getFileType().toString());
        viewModel.setInfoTitle(responseModel.getName());
        viewModel.setIntro(responseModel.getBio());
        viewModel.setLeftTable(getLeftTable(responseModel));
        viewModel.setRightTable(getRightTable(responseModel));
        viewModel.setVisualLevel(responseModel.getVisualLevel());
        viewModel.setFunction(new ControllerFactory().getUseCases(responseModel));
        viewModel.setDpt(responseModel.getDpt());
        viewModel.setScreenType(getScreenType(responseModel));
    }

    private ScreenType getScreenType(CheckProfileResponseModel responseModel) {
        switch (responseModel.getFileType()){
            case LEAVE_REQUEST_PROJECT_FILE:
            case PROJECT_FILE:return ScreenType.PROJECT_SCREEN;
            case LEAVE_REQUEST_TASK_FILE:
            case EVALUATION_TASK_FILE:
            case TASK_FILE: return ScreenType.TASK_SCREEN;
            case USER_FILE:return ScreenType.USER_SCREEN;
            case DEPARTMENT_FILE:return ScreenType.DEPARTMENT_SCREEN;
        }
        return null;
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
        for (int i =0; i < list.length; i++){
            Object item = responseModel.getList1().get(i);
            SetTableContent(list, i, item);
        }
        return new Table(columnName, list, responseModel.getReference1());
    }
    private Table getRightTable(CheckProfileResponseModel responseModel) {
        String[] columnName = new String[1];
        columnName[0] = responseModel.getList2Name();
        Object[][] list = new Object[responseModel.getList2().size()][1];
        for (int i =0; i < list.length; i++){
            Object item = responseModel.getList2().get(i);
            SetTableContent(list, i, item);
        }
        return new Table(columnName, list, responseModel.getReference2());
    }

    private void SetTableContent(Object[][] list, int i, Object item) {
        String itemName = "";
        if (item instanceof Organization){
            itemName = ((Organization) item).getName();
        }else if(item instanceof User){
            itemName = ((User) item).getName();
        }
//       else {
//            itemName = "Not User, Not Organization";
//        }
        list[i][0] = itemName;
    }


    @Override
    public void update() {

    }

    public IViewModel getViewModel() {
        return viewModel;
    }
//
//    private void show(JFrame frame) {
//        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }

}
