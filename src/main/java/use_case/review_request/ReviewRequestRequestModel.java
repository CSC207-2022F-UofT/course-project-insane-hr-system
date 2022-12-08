package use_case.review_request;

import java.util.UUID;

public class ReviewRequestRequestModel {
    private UUID oid;
    private boolean approval;

    public ReviewRequestRequestModel(UUID oid, boolean approval) {
        this.oid = oid;
        this.approval = approval;
    }

    public UUID getOid() {
        return oid;
    }

    public void setOid(UUID oid) {
        this.oid = oid;
    }

    public boolean getApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }
}
