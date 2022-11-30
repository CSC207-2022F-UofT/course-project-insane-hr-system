package data_access;

import check_profile_validation.CheckProfileIGateway;
import entity.Organization;
import entity.Role;
import entity.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.UUID;

public class CheckProfileGateway implements CheckProfileIGateway {
//TODO: implement this gateway.

    private final PropertyChangeSupport observable;

    public CheckProfileGateway() {
        this.observable = new PropertyChangeSupport(this);

    }

    @Override
    public List<Role> getUserRolesByUid(Integer requester) {
        return null;
    }

    @Override
    public User getUserByUid(Integer requester) {
        return null;
    }

    @Override
    public PropertyChangeSupport getObservable() {
        return observable;
    }
    @Override
    public void addObserver(PropertyChangeListener observer) {
        observable.addPropertyChangeListener("FrameNameChange", observer);
        observable.addPropertyChangeListener("TitleChange", observer);
        observable.addPropertyChangeListener("IntroChange", observer);
        observable.addPropertyChangeListener("LeftTableChange", observer);
        observable.addPropertyChangeListener("RightTableChange", observer);
    }


    @Override
    public Organization getOrgByOid(UUID oid) {
        return null;
    }

}
