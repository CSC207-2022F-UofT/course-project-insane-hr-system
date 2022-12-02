package rank_employees_use_case;


import entity.CommonTask;
import entity.CommonUser;

import java.util.HashMap;
import java.util.List;

public interface RankGateway {

    HashMap<CommonUser, List<CommonTask>> getTaskSummary(List<CommonUser> subordinateIds);

    void save(RankRequestModel requestModel);
}
