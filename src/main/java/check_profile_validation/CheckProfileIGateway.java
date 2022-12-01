package check_profile_validation;

import entity.Organization;
import entity.Project;
import entity.Role;
import entity.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.UUID;

public interface CheckProfileIGateway {
    List<Role> getUserRolesByUid(Integer target);

    User getUserByUid(Integer target);

    PropertyChangeSupport getObservable();

    void addObserver(PropertyChangeListener observer);

    Organization getOrgByOid(UUID oid);

    User getFakeUserByUid(Integer target);
}
