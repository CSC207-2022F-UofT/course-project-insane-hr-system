package rank_employees;


import entity.CommonTask;
import entity.CommonUser;

import java.util.*;

public class RankInteractor implements RankInputBoundary {
    final RankGateway rankGateway;
    final RankOutputBoundary rankOutput;

    public RankInteractor(RankGateway rankGateway, RankOutputBoundary outputBoundary){
        this.rankGateway = rankGateway;
        this.rankOutput = outputBoundary;
    }

    @Override
    public RankResponseModel rankEmployees(RankRequestModel requestModel) {

        // get a list of subordinate department members.
        List<CommonUser> subordinates = this.rankGateway.getDepartmentMembers(requestModel);
        TreeMap<Integer, List<CommonUser>> memberRatingMap = new TreeMap<>();

        for (int i = 0; i < subordinates.size(); i++) {

            List<CommonTask> memberTasks = this.rankGateway.getCompletedTasks(subordinates.get(i));
            int memberRating = getMemberRating(memberTasks);

            if(memberRatingMap.containsKey(memberRating)){
                List<CommonUser> memberList =  memberRatingMap.get(memberRating);
                memberList.add(subordinates.get(i));
            }
            else{
                List<CommonUser> ratingList = new ArrayList<>();
                ratingList.add(subordinates.get(i));
                memberRatingMap.put(memberRating, ratingList);
            }

        }

        RankResponseModel responseModel = new RankResponseModel(sortByRating(memberRatingMap));
        return rankOutput.displayRanking(responseModel);

    }


    ///////////////// HELPER METHODS ///////////////////

    public int getMemberRating(List<CommonTask> memberTasks){
        int totalRating = 0;
        for(int i = 0; i < memberTasks.size(); i++){
            totalRating += memberTasks.get(i).getStar();
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
