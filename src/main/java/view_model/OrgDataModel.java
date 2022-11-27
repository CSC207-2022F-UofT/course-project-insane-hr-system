package view_model;

import java.util.UUID;

public class OrgDataModel extends UIDataModel{
    private final UUID oid;
    private final OrgType orgType;

    public OrgDataModel(UUID oid, OrgType orgType, String frameName, String infoTitle, String intro, Table leftTable, Table rightTable) {
        super(frameName, infoTitle, intro, leftTable, rightTable);
        this.oid = oid;
        this.orgType = orgType;
    }

    public UUID getOid() {
        return oid;
    }

    public OrgType getOrganizationType() {
        return orgType;
    }
}
