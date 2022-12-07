package entity;

public class PositionSetter {
    public static void setPositionBasedOnGivenUser(User user){
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
        user.setPosition(Position.MEMBER);
    }
}