package data_access;

import DAO.TaskDAO;
import DAO.UserDAO;
import DAOInterfaces.DepartmentDAOInterface;
import DAOInterfaces.TaskDAOInterface;
import entity.CommonTask;
import entity.CommonUser;
import entity.Task;
import entity.TaskFactory;
import rank_employees_use_case.RankGateway;
import rank_employees_use_case.RankRequestModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import DAOInterfaces.UserDAOInterface;

import static entity.Constants.CLOSED;
import static entity.Constants.COMMON;

public class RankDataAccess implements RankGateway {
    @Override
    public List<CommonUser> getSubordinates(RankRequestModel requestModel) {
        CommonUser currentUser = requestModel.getCurrentUser();
        List<CommonUser> subordinates = new ArrayList<>();
        List<Integer> memberIDs = new ArrayList<>(currentUser.getDpt().getMembers());
        for(int i = 0; i< memberIDs.size(); i++){
            CommonUser user = (CommonUser) new UserDAO().getUser(memberIDs.get(i));
            subordinates.add(user);

        }
        return subordinates;

    }

    @Override
    public List<CommonTask> getCompletedTasks(CommonUser user) {
        List<Task> tasks = new TaskDAO().getAllTasks();
        List<CommonTask> completedTasks = new ArrayList<>();
        for(int i=0; i< tasks.size(); i++){
            Task task = tasks.get(i);
            if (task.getType().equals(COMMON) && task.getState().equals(CLOSED) && task.getMembers().contains(user.getId())){
                completedTasks.add((CommonTask) task);


            }


        }
        return completedTasks;

    }
}
