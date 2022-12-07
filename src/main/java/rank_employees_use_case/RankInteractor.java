package rank_employees_use_case;


import entity.CommonTask;
import entity.CommonUser;
import presenter.RankPresenter;

import java.util.*;

public class RankInteractor implements RankInputBoundary {
    final RankGateway rankGateway;
    final RankPresenter rankPresenter;

    public RankInteractor(RankGateway rankGateway, RankPresenter rankPresenter){
        this.rankGateway = rankGateway;
        this.rankPresenter = rankPresenter;
    }

    @Override
    public RankResponseModel create(RankRequestModel requestModel) {

        // get a list of subordinates.
        List<CommonUser> subordinates = this.rankGateway.getAllSubordinates(requestModel);

        for (int i = 0; i < subordinates.size(); i++) {
            List<CommonTask> memberTasks = this.rankGateway.getMemberTasks(subordinates.get(i));

        }

    }



}
