package presenter;

import entity.RelativeRelation;
import ui.ScreenBuilder;

import java.util.LinkedList;
import java.util.List;

public class ButtonFactory {
    RelativeRelation relation;
    public ButtonFactory(RelativeRelation relation) {
        this.relation = relation;
    }


    UseCase[] getUseCases(RelativeRelation relation) {
        List<UseCase> useCases = new LinkedList<>();

        for (UseCase useCase : UseCase.values()) {
            if (functionIsInNeed(useCase)) {
                useCases.add(useCase);
            }
        }
        return useCases.toArray(new UseCase[0]);
    }

    private boolean functionIsInNeed(UseCase useCase) {
        switch (useCase) {
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

    public UseCase[] getAllUseCases() {

        return new UseCase[0];
    }
}
