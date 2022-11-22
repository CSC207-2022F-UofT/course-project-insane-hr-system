package entity;

import java.util.UUID;

public class RoleFactory implements IRoleFactory{
    @Override
    public CommonRole createCommonRole(Position position, Organization organization) {
        return new CommonRole(position, organization.getName(), organization.getOid());
    }

    @Override
    public CommonRole createCommonRole(Position position, String orgName, UUID oID) {
        return new CommonRole(position, orgName, oID);
    }

    @Override
    public SuperRole createSuperRole() {
        return new SuperRole(Position.CEO, "CEO");
    }

    @Override
    public SuperRole createSuperRole(String CEOName) {
        return new SuperRole(Position.CEO, CEOName);
    }
}
