package rank_employees_use_case;


import entity.CommonTask;
import entity.CommonUser;
import entity.User;

import java.util.HashMap;
import java.util.List;

public interface RankGateway {

    public List<CommonUser> getAllSubordinates(RankRequestModel requestModel);

    public List<CommonTask> getMemberTasks(CommonUser user);


}
