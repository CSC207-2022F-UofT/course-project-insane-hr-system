package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoleAllowed {

    public static boolean isHeadOf(List<Role> roles, List<Role> targetRoles) {
        for (Role role : roles) {
            if (role.getPosition() == Position.HEADOF) {
                return true;
            }
        }
        for (Role role : roles) {
            if (role instanceof CommonRole) {
                CommonRole commonRole = ((CommonRole) role);
                for (Role targetRole : targetRoles) {
                    if (targetRole instanceof CommonRole) {
                        CommonRole targetCommonRole = ((CommonRole) targetRole);
                        if (commonRole.getPosition() == Position.HEAD && commonRole.getOid() == targetCommonRole.getOid()) {
                            return true;
                        }
                    }
                }
            }

        }

        return false;
    }

    public static boolean hasOverlapOrg(List<Role> roles, List<Role> targetRoles) {
        for (Role role : roles) {
            if (role.getPosition() == Position.HASOVERLAPORG) {
                return true;
            }
        }
        for (Role role : roles) {
            if (role instanceof SuperRole) {
                return true;
            }
        }
//        for (Role role : roles) {
//            if (role instanceof SameOrgRole) {
//                return true;
//            }
//        }
        for (Role role : roles) {
            if (role instanceof CommonRole) {
                CommonRole commonRole = ((CommonRole) role);
                for (Role targetRole : targetRoles) {
                    if (targetRole instanceof CommonRole) {
                        CommonRole targetCommonRole = ((CommonRole) targetRole);
                        if (commonRole.getOid() == targetCommonRole.getOid()) {
                            return true;
                        }
                    }
                }
            }

        }

        return false;
    }

    public static boolean isInSameOrg(List<Role> roles, List<Role> targetRoles, UUID projectID) {
        for (Role role : roles) {
            if (role.getPosition() == Position.SAMEPROJECT) {
                return true;
            }
        }
        return roleOfOrg(roles, projectID).size() > 0 && roleOfOrg(targetRoles, projectID).size() > 0;
    }

    private static List<CommonRole> getCommonRole(List<Role> roles) {
        List<CommonRole> commonRoles = new ArrayList<>();
        for (Role role : roles) {
            if (role instanceof CommonRole) {
                commonRoles.add((CommonRole) role);
            }
        }
        return commonRoles;
    }
    private static boolean hasSuper(List<Role> roles) {
        for (Role role : roles) {
            if (role instanceof SuperRole) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCEO(List<Role> roles) {
        for (Role role : roles) {
            if (role.getPosition() == Position.CEO) {
                return true;
            }
        }
        return false;
    }
    public static List<CommonRole> roleOfOrg(List<Role> roles, UUID oid) {
        List<CommonRole> results = new ArrayList<>();
        for (CommonRole role : getCommonRole(roles)) {
            if (role.getOid() == oid) {
                results.add(role);
            }
        }
        return  results;
    }

    public static RelativeRelation getRelation(User user1, User user2) {
        if (user1.equals(user2)) {
            switch (user1.getPosition()){
                case CEO: return RelativeRelation.IS_CEO_OF;
                case HEAD: if (isDptHeadOf(user1, user2)) return RelativeRelation.IS_DPT_HEAD_SELF;else return RelativeRelation.IS_PM_SELF;
                case MEMBER: return RelativeRelation.IS_EMPLOYEE_SELF;
            }

        }
        if (hasSuper(user1.getRoles())) return RelativeRelation.IS_SUPER;
        else if (hasCEO(user1.getRoles())) return RelativeRelation.IS_CEO_OF;
        else if (isDptHeadOf(user1, user2)) return RelativeRelation.IS_DPT_HEAD_OF;
        else if (isHeadOf(user1.getRoles(), user2.getRoles())) return RelativeRelation.IS_P_M_OF;
        return RelativeRelation.NO_RELATION;
    }

    public static RelativeRelation getRelation(User user, Organization org) {
        if (roleOfOrg(user.getRoles(), org.getOid()).size() == 2) return RelativeRelation.IS_HEAD_OF;
        else if (roleOfOrg(user.getRoles(), org.getOid()).size() == 2) return RelativeRelation.IS_MEMBER_OF;
        return RelativeRelation.NO_RELATION;
    }
    private static boolean isDptHeadOf(User user1, User user2) {
        for (UUID oidHeaded : getOidHeaded(user1.getRoles())) {
            if (user1.getDpt().getOid().equals(oidHeaded) && user2.getDpt().getOid() == oidHeaded) return true;
        }
        return false;
    }

    public static List<UUID> getOidHeaded(List<Role> roles) {
        List<UUID> result = new ArrayList<>();
        for (CommonRole role : getCommonRole(roles)) {
            if (role.getPosition() == Position.HEAD) {
                result.add(role.getOid());
            }
        }
        return result;
    }
}
