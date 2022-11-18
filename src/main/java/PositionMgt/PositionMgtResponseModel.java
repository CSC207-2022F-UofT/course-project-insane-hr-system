package PositionMgt;

import Entity.User;

public class PositionMgtResponseModel {
    private User AfterPromote;
    private User AfterDemote;

    public PositionMgtResponseModel(User AfterPromote, User AfterDemote) {
        this.AfterPromote = AfterPromote;
        this.AfterDemote = AfterDemote;
    }

    public User getAfterDemote() {
        return AfterDemote;
    }

    public User getAfterPromote() {
        return AfterPromote;
    }

    public void setAfterDemote(User afterDemote) {
        AfterDemote = afterDemote;
    }

    public void setAfterPromote(User afterPromote) {
        AfterPromote = afterPromote;
    }
}
