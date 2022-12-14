package entity.role;

import entity.Organization;
import entity.user.User;

import java.util.UUID;

public interface IRoleFactory {

    CommonRole createCommonRole(Position position, Organization organization);

    CommonRole createCommonRole(Position position, String orgName, UUID oID);

    SuperRole createSuperRole();

    SuperRole createSuperRole(String CEOName);

    void addRoleToUserBasedOnOrg(User user);
}

