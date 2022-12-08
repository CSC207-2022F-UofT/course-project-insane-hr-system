package rank_employees;


import entity.CommonTask;
import entity.CommonUser;

import java.util.List;

public interface RankGateway {

    public List<CommonUser> getDepartmentMembers(RankRequestModel requestModel);

    public List<CommonTask> getCompletedTasks(CommonUser user);


}
