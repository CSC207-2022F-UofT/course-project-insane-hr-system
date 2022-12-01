package RankEmployeesUseCase;


import Entity.CommonTask;
import Entity.CommonUser;

import java.util.HashMap;
import java.util.List;

public interface RankGateway {

    HashMap<CommonUser, List<CommonTask>> getTaskSummary(List<CommonUser> subordinateIds);

    void save(RankRequestModel requestModel);
}
