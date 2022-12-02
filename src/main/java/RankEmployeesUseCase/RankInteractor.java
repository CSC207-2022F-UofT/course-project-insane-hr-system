package RankEmployeesUseCase;


import entity.CommonTask;
import entity.CommonUser;

import java.lang.reflect.Array;
import java.util.*;

public class RankInteractor implements RankInputBoundary {
    final RankGateway rankGateway;
    final RankPresenter rankPresenter;

    public RankInteractor(RankGateway rankGateway, RankPresenter rankPresenter){
        this.rankGateway = rankGateway;
        this.rankPresenter = rankPresenter;
    }

    @Override
    public RankResponseModel create(RankRequestModel requestModel){

        /// get a list of subordinates.
        List<CommonUser> subordinateList = requestModel.getSubordinates();

        /// get tasks of each subordinate.
        HashMap<CommonUser, List<CommonTask>> subordinateTasks = this.rankGateway.getTaskSummary(subordinateList);

        /// for each subordinate get an average task score.
        HashMap<Integer, List<CommonUser>> avgTaskScores = new HashMap<>();

        for(int i = 0; i < subordinateList.size(); i++){
            CommonUser subordinate = subordinateList.get(i);
            List<CommonTask> userTasks = subordinateTasks.get(subordinate);

            /// get the average score of all tasks.
            Integer totalScore = 0;
            for(int p = 0; p < userTasks.size(); p++){
                totalScore += userTasks.get(i).getStar();

            }
            Integer avgScore = totalScore/userTasks.size();
            if(!avgTaskScores.containsKey(avgScore)){
                List<CommonUser> selectedUser = new ArrayList<>();
                selectedUser.add(subordinate);
                avgTaskScores.put(avgScore, selectedUser);

            }
            else{
                avgTaskScores.get(avgScore).add(subordinate);
            }

        }

        /// sort map by keys.
        Integer[] sortedKeys = (Integer[]) avgTaskScores.keySet().toArray();
        Arrays.sort(sortedKeys, Collections.reverseOrder());

        /// get the final list of ranked employees
        List<CommonUser> rankedEmployees = new ArrayList<>();
        for(int i = 0; i < sortedKeys.length; i++){
            rankedEmployees.addAll(avgTaskScores.get(sortedKeys[i]));
        }

        RankResponseModel returnModel = new RankResponseModel(rankedEmployees);
        return (RankResponseModel) returnModel.getRankedEmployees();
    }



}
