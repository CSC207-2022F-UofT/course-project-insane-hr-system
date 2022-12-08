package use_case.check_profile_validation;

import entity.Organization;
import entity.user.User;

import java.beans.PropertyChangeListener;
import java.util.UUID;

public interface CheckProfileIGateway {
//    List<Role> getUserRolesByUid(Integer target);

    User getUserByUid(Integer target);

//    PropertyChangeSupport getObservable();

    void addObserver(PropertyChangeListener observer);

    Organization getOrgByOid(UUID oid);

//    User getFakeUserByUid(Integer target);
}
