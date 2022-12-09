package entity.role;

import entity.Organization;
import entity.project.Project;
import entity.task.Task;
import entity.user.User;

import java.util.ArrayList;
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

    @Override
    public void addRoleToUserBasedOnOrg(User user) {
        user.setRoles(new ArrayList<>());
        for (Project project : user.getProjects()) {
            user.addRole(createCommonRole(Position.MEMBER, project.getName(), project.getOid()));
            if (project.getHead() == user.getId()) {
                user.addRole(createCommonRole(Position.HEAD, project.getName(), project.getOid()));
            }
         }
        for (Task project : user.getTasks()) {
            user.addRole(createCommonRole(Position.MEMBER, project.getName(), project.getOid()));
            if (project.getHead() == user.getId()) {
                user.addRole(createCommonRole(Position.HEAD, project.getName(), project.getOid()));
            }
        }
        user.addRole(createCommonRole(Position.MEMBER, user.getDpt().getName(), user.getDpt().getOid()));
        if (user.getDpt().getHead() == user.getId()) {
            user.addRole(createCommonRole(Position.HEAD, user.getDpt().getName(), user.getDpt().getOid()));
        }
        if (user.getPosition()==Position.CEO){
            user.addRole(new SuperRole(Position.CEO, "CEO_ROLE"));
        }

    }
}
