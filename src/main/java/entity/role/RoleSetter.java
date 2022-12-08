package entity.role;

import entity.project.Project;
import entity.task.Task;
import entity.user.User;

import java.util.ArrayList;
import java.util.List;

public class RoleSetter {

    /**
     * This will reset the Role of user based on the project that is created in the user object.
     * @param user with proper project
     * @return the new user
     */
    public User resetRoleOfUser(User user) {
        IRoleFactory roleFactory = new RoleFactory();
        List<Role> roles = new ArrayList<>();

        for (Role role : user.getRoles()) {
            if (role.getPosition() == Position.CEO) {
                roles.add((Role) roleFactory.createSuperRole());
            }
        }
        if (user.getDpt().getHead() == user.getId()) {
            roles.add(roleFactory.createCommonRole(Position.HEAD, user.getDpt()));
        }
        roles.add(roleFactory.createCommonRole(Position.MEMBER, user.getDpt()));

        for (Project project : user.getProjects()) {
            if (project.getHead() == user.getId()) {
                roles.add(roleFactory.createCommonRole(Position.HEAD, project));
            }
            roles.add(roleFactory.createCommonRole(Position.MEMBER, project));
        }
        for (Task task : user.getTasks()) {
            if (task.getHead() == user.getId()) {
                roles.add(roleFactory.createCommonRole(Position.HEAD, task));
            }
            roles.add((roleFactory.createCommonRole(Position.MEMBER, task)));
        }
        user.setRoles(roles);
        return user;
    }
}
