package PositionMgt;

import Entity.RolesAllowed;
import Entity.User;

public class PositionMgtRequestModel {
    User toPromote;
    RolesAllowed RoleAfterPromote;
    User toDemote;
    RolesAllowed RoleAfterDemote;

    public PositionMgtRequestModel(User toPromote, RolesAllowed RoleAfterPromote,
                                   User toDemote, RolesAllowed RoleAfterDemote) {
        this.toPromote = toPromote;
        this.RoleAfterPromote = RoleAfterPromote;
        this.toDemote = toDemote;
        this.RoleAfterDemote = RoleAfterDemote;
    }

    public User getToDemote() {
        return toDemote;
    }

    public User getToPromote() {
        return toPromote;
    }

    public RolesAllowed getRoleAfterDemote() {
        return RoleAfterDemote;
    }

    public RolesAllowed getRoleAfterPromote() {
        return RoleAfterPromote;
    }

    public void setRoleAfterDemote(RolesAllowed roleAfterDemote) {
        RoleAfterDemote = roleAfterDemote;
    }

    public void setRoleAfterPromote(RolesAllowed roleAfterPromote) {
        RoleAfterPromote = roleAfterPromote;
    }

    public void setToDemote(User toDemote) {
        this.toDemote = toDemote;
    }

    public void setToPromote(User toPromote) {
        this.toPromote = toPromote;
    }
}