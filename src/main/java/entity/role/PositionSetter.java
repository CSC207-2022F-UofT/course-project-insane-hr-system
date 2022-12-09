package entity.role;

import entity.project.CommonProject;
import entity.project.Project;
import entity.user.User;

public class PositionSetter {
    public static void setPositionBasedOnGivenUser(User user){
        //CEO will not be effected by this method
        if(user.getPosition() == Position.CEO){
            return;
        }
        // Dpt Head and project Head will set to Head
        if(user.getDpt().getHead() == user.getId()){
            user.setPosition(Position.HEAD);
            return;
        }

        for (Project project : user.getProjects()){
            if (project instanceof CommonProject && project.getHead() == user.getId()){
                user.setPosition(Position.HEAD);
                return;
            }
        }
        //Others become Member
        user.setPosition(Position.MEMBER);
    }
}
