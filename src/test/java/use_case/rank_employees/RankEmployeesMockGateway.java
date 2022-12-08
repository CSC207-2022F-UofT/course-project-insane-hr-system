package use_case.rank_employees;

import entity.CommonTask;
import entity.CommonUser;
import rank_employees.RankGateway;
import rank_employees.RankRequestModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RankEmployeesMockGateway implements RankGateway {
    @Override
    public List<CommonUser> getDepartmentMembers(RankRequestModel requestModel) {
        return new RankRequestModel()

    }

    @Override
    public List<CommonTask> getCompletedTasks(CommonUser user) {
        return null;
    }
}
