package entity;

public enum RelativeRelation {
    // constant for user - user relation
    IS_SUPER,
    IS_CEO_OF,
    IS_DPT_HEAD_OF,
    IS_P_M_OF,
    IS_EMPLOYEE_SELF,
    IS_PM_SELF,
    IS_DPT_HEAD_SELF,
    // Constant for user - org relation
    IS_MEMBER_OF,
    IS_HEAD_OF,
    // constant for both
    NO_RELATION,
}
