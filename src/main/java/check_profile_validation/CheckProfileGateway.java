package check_profile_validation;

import entity.Organization;
import entity.Project;
import entity.Role;
import entity.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.UUID;

public class CheckProfileGateway {
    private final PropertyChangeSupport observable;

    public CheckProfileGateway() {
        this.observable = new PropertyChangeSupport(this);

    }

    public List<Role> getUserRolesByUid(Integer requester) {
        return null;
    }

    public List<Project> getUserCurrentProjectByUid(Integer requester) {
        return null;
    }

    public User getUserByUid(Integer requester) {
        return null;
    }

    public PropertyChangeSupport getObservable() {
        return observable;
    }
    public void addObserver(PropertyChangeListener observer) {
        observable.addPropertyChangeListener("FrameNameChange", observer);
        observable.addPropertyChangeListener("TitleChange", observer);
        observable.addPropertyChangeListener("IntroChange", observer);
        observable.addPropertyChangeListener("LeftTableChange", observer);
        observable.addPropertyChangeListener("RightTableChange", observer);
    }


    public Organization getOrgByOid(UUID oid) {
        return null;
    }

}
