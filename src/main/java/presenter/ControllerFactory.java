package presenter;

import entity.RelativeRelation;

import java.util.LinkedList;
import java.util.List;

public class ControllerFactory {
    public ControllerFactory() {
    }


    Controllers[] getUseCases(RelativeRelation relation) {
        List<Controllers> controllers = new LinkedList<>();

        for (Controllers controller : Controllers.values()) {
            if (functionIsInNeed(controller, relation)) {
                controllers.add(controller);
            }
        }
        return controllers.toArray(new Controllers[0]);
    }


    public Controllers[] getAllUseCases() {
        return new Controllers[0];
    }
    private boolean functionIsInNeed(Controllers controllers, RelativeRelation relation) {
        switch (controllers) {
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
}
