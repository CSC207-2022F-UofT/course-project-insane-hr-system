package use_case.rank_employees;


import entity.task.CommonTask;
import entity.user.CommonUser;

import java.util.List;

public interface RankGateway {

    /*
    Get a List of Common Users that are subordinates in the current User's department from the Database.
     */
    List<CommonUser> getSubordinates(RankRequestModel requestModel);

    /*
    Get a list of CommonTasks that are completed by a CommonUser.
     */
    List<CommonTask> getCompletedTasks(CommonUser user);


}
