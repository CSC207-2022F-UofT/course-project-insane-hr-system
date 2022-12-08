package data_access;

import DAO.TaskDAO;
import DAO.UserDAO;
import entity.CommonTask;
import entity.CommonUser;
import entity.Department;
import entity.Task;
import rank_employees.RankGateway;
import rank_employees.RankRequestModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static entity.Constants.CLOSED;
import static entity.Constants.COMMON;

public class RankDataAccess implements RankGateway {
    @Override
    public List<CommonUser> getDepartmentMembers(RankRequestModel requestModel) {
        Department dept = requestModel.getCurrentDepartment();
        List<CommonUser> subordinates = new ArrayList<>();
        List<Integer> memberIDs = new ArrayList<>(dept.getMembers());
        for(int i = 0; i< memberIDs.size(); i++){

            CommonUser user = (CommonUser) new UserDAO().getUser(memberIDs.get(i));
            if(dept.getHead().equals(user.getId()) == false) {
                subordinates.add(user);
            }

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
