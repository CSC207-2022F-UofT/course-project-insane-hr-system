package use_case.rank_employees;


import entity.task.CommonTask;
import entity.user.CommonUser;

import java.util.*;

public class RankInteractor implements RankInputBoundary {
    final RankGateway rankGateway;
    final RankOutputBoundary rankOutput;

    public RankInteractor(RankGateway rankGateway, RankOutputBoundary outputBoundary){
        this.rankGateway = rankGateway;
        this.rankOutput = outputBoundary;
    }

    @Override
    public RankResponseModel create(RankRequestModel requestModel) {

        // get a list of subordinates.
        List<CommonUser> subordinates = this.rankGateway.getSubordinates(requestModel);
        TreeMap<Integer, List<CommonUser>> memberRatingMap = new TreeMap<>();

        for (CommonUser subordinate : subordinates) {

            List<CommonTask> memberTasks = this.rankGateway.getCompletedTasks(subordinate);
            int memberRating = getMemberRating(memberTasks);

            if (memberRatingMap.containsKey(memberRating)) {
                List<CommonUser> memberList = memberRatingMap.get(memberRating);
                memberList.add(subordinate);
            } else {
                List<CommonUser> ratingList = new ArrayList<>();
                ratingList.add(subordinate);
                memberRatingMap.put(memberRating, ratingList);
            }

        }

        RankResponseModel responseModel = new RankResponseModel(sortByRating(memberRatingMap));
        return rankOutput.displayRanking(responseModel);

    }


    ///////////////// HELPER METHODS ///////////////////

    public int getMemberRating(List<CommonTask> memberTasks){
        int totalRating = 0;
        for (CommonTask memberTask : memberTasks) {
            totalRating += memberTask.getStar();
        }

        return totalRating/memberTasks.size();

    }

    public List<CommonUser> sortByRating(TreeMap<Integer, List<CommonUser>> memberRatingMap){
        List<Integer> ratingList = new ArrayList<> (memberRatingMap.keySet());
        List<CommonUser> sortedUsers = new ArrayList<>();


        for(int i = 1; i <= ratingList.size(); i++){
            Integer ratingKey = ratingList.get(ratingList.size() - i);
            List<CommonUser> ratingUsers = memberRatingMap.get(ratingKey);
            sortedUsers.addAll(ratingUsers);
        }
        return sortedUsers;


    }




}
