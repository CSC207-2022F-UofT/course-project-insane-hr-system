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

    /*
    Get a list of CommonUsers that are Department members of the Department the current User belong to except for the head
    of the Department.
     */
    @Override
    public List<CommonUser> getSubordinates(RankRequestModel requestModel) {
        int userId = requestModel.getUserId();
        CommonUser user = (CommonUser) new UserDAO().getUser(userId);

        List<CommonUser> subordinates = new ArrayList<>();
        List<Integer> memberIDs = new ArrayList<>(user.getDpt().getMembers());
        for (Integer memberID : memberIDs) {
            CommonUser subordinate = (CommonUser) new UserDAO().getUser(memberID);
            subordinates.add(subordinate);

        }
        return subordinates;

    }

    /*
    Get a list of completed Tasks for a CommonUser.
     */
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
