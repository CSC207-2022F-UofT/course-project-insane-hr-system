package check_profile_validation;

import java.util.UUID;

public class CheckOrgFileRequestModel extends CheckProfileRequestModel{
    private final UUID oid;

    public CheckOrgFileRequestModel(Integer requester, UUID oid) {
        super(requester);
        this.oid = oid;
    }

    public UUID getOid() {
        return oid;
    }
}
