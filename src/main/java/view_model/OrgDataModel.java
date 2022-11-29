package view_model;

import presenter.OrgIViewModel;

import java.util.UUID;

public class OrgDataModel extends UIDataModel implements OrgIViewModel {
    private UUID oid;

    public OrgDataModel(UUID oid) {
        this.oid = oid;
    }

    public OrgDataModel(UUID oid, String frameName, String infoTitle, String intro, Table leftTable, Table rightTable) {
        super(frameName, infoTitle, intro, leftTable, rightTable);
        this.oid = oid;
    }

    public UUID getOid() {
        return oid;
    }

    public void setOid(UUID oid) {

    }

}
