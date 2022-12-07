package rank_employees_use_case;


import entity.CommonTask;
import entity.CommonUser;
import entity.Department;
import entity.User;

import java.util.HashMap;
import java.util.List;

public interface RankGateway {

    public List<CommonUser> getSubordinates(RankRequestModel requestModel);

    public List<CommonTask> getCompletedTasks(CommonUser user);


}
