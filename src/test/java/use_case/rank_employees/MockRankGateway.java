package use_case.rank_employees;

import entity.task.CommonTask;
import entity.user.CommonUser;

import java.util.List;

public class MockRankGateway implements RankGateway{


    @Override
    public List<CommonUser> getSubordinates(RankRequestModel requestModel) {
        return null;
    }

    @Override
    public List<CommonTask> getCompletedTasks(CommonUser user) {
        return null;
    }
}
