package use_case.rank_employees;


import entity.task.CommonTask;
import entity.user.CommonUser;

import java.util.List;

public interface RankGateway {

    List<CommonUser> getSubordinates(RankRequestModel requestModel);

    List<CommonTask> getCompletedTasks(CommonUser user);


}
