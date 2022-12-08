package data_access;

import DAO.TaskDAO;
import DAO.UserDAO;
import entity.task.CommonTask;
import entity.user.CommonUser;
import entity.task.Task;
import use_case.rank_employees.RankGateway;
import use_case.rank_employees.RankRequestModel;

import java.util.ArrayList;
import java.util.List;

import static entity.Constants.CLOSED;
import static entity.Constants.COMMON;

public class RankDataAccess implements RankGateway {
    @Override
    public List<CommonUser> getSubordinates(RankRequestModel requestModel) {
        CommonUser currentUser = requestModel.getCurrentUser();
        List<CommonUser> subordinates = new ArrayList<>();
        List<Integer> memberIDs = new ArrayList<>(currentUser.getDpt().getMembers());
        for (Integer memberID : memberIDs) {
            CommonUser user = (CommonUser) new UserDAO().getUser(memberID);
            subordinates.add(user);

        }
        return subordinates;

    }

    @Override
    public List<CommonTask> getCompletedTasks(CommonUser user) {
        List<Task> tasks = new TaskDAO().getAllTasks();
        List<CommonTask> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getType().equals(COMMON) && task.getState().equals(CLOSED) && task.getMembers().contains(user.getId())) {
                completedTasks.add((CommonTask) task);
            }


        }
        return completedTasks;

    }
}
