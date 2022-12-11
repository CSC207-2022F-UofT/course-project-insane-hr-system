package presenter;

import use_case.check_profile_validation.CheckProfileResponseModel;
import use_case.check_profile_validation.FileType;
import entity.role.RelativeRelation;

import java.util.LinkedList;
import java.util.List;

public class ControllerFactory {
    public ControllerFactory() {
    }


    Controllers[] getUseCases(CheckProfileResponseModel responseModel) {
        List<Controllers> controllers = new LinkedList<>();

        for (Controllers controller : Controllers.values()) {
            if (functionIsInNeed(controller, responseModel)) {
                controllers.add(controller);
            }
        }
        return controllers.toArray(new Controllers[0]);
    }


    public Controllers[] getAllUseCases() {
        return new Controllers[0];
    }
    private boolean functionIsInNeed(Controllers controllers, CheckProfileResponseModel responseModel) {
        RelativeRelation relation = responseModel.getRelation();
        switch (controllers) {
            case CREATE_TASK: return relation == RelativeRelation.IS_HEAD_OF && responseModel.getFileType()== FileType.PROJECT_FILE;
            case LEAVE_REQUEST: return relation == RelativeRelation.IS_EMPLOYEE_SELF;
            case CREATE_PROJECT:return relation == RelativeRelation.IS_SUPER || relation == RelativeRelation.IS_DPT_HEAD_SELF || (responseModel.getFileType() == FileType.DEPARTMENT_FILE && relation == RelativeRelation.IS_HEAD_OF);
            case ENROLL_EMPLOYEE: return relation == RelativeRelation.IS_DPT_HEAD_SELF;
            case SALARY_CALCULATOR: return relation == RelativeRelation.IS_EMPLOYEE_SELF || relation == RelativeRelation.IS_PM_SELF;
            case COMPLETE_PROJECT: return relation == RelativeRelation.IS_HEAD_OF && responseModel.getFileType() != FileType.LEAVE_REQUEST_PROJECT_FILE;
            case COMPLETE_TASK: return relation == RelativeRelation.IS_MEMBER_OF && responseModel.getFileType() == FileType.TASK_FILE;
            case EVALUATE_TASK: return relation == RelativeRelation.IS_HEAD_OF && responseModel.getFileType() == FileType.EVALUATION_TASK_FILE;
            case APPROVE_LEAVE_TASK: return relation == RelativeRelation.IS_MEMBER_OF && responseModel.getFileType() == FileType.LEAVE_REQUEST_TASK_FILE;
            case RANK_EMPLOYEE: return responseModel.getFileType() == FileType.DEPARTMENT_FILE && relation != RelativeRelation.NO_RELATION;

        }
        return false;
    }
}
