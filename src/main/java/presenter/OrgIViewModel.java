package presenter;

import java.util.UUID;

public interface OrgIViewModel extends IViewModel{
    UUID getOid();
    void setOid(UUID oid);
}
