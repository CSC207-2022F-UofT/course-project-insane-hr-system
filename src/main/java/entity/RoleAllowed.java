package entity;

import java.util.List;

public class RoleAllowed {

    public static boolean isHeadOf(List<Role> roles, List<Role> targetRoles) {
        for (Role role : targetRoles) {
            if (role instanceof SuperRole) {
                return false;
            }
        }
        for (Role role : roles) {
            if (role instanceof SuperRole) {
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

    public static boolean isInSameOrg(List<Role> roles, List<Role> targetRoles) {
        for (Role role : targetRoles) {
            if (role instanceof SuperRole) {
                return true;
            }
        }
        for (Role role : roles) {
            if (role instanceof SuperRole) {
                return true;
            }
        }
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


}
