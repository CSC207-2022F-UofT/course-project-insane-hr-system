package data_access;


import DAO.DepartmentDAO;
import DAO.ProjectDAO;
import DAO.TaskDAO;
import DAO.UserDAO;
import DAO.DepartmentDAOInterface;
import DAO.ProjectDAOInterface;
import DAO.TaskDAOInterface;
import DAO.UserDAOInterface;
import use_case.check_profile_validation.CheckProfileIGateway;
import entity.Organization;
import entity.user.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.UUID;

public class CheckProfileDataAccess implements CheckProfileIGateway {
//TODO: implement this gateway.

    private final DepartmentDAOInterface dptDB = new DepartmentDAO();
    private final UserDAOInterface userDB = new UserDAO();
    private final TaskDAOInterface taskDB = new TaskDAO();
    private final ProjectDAOInterface projectDB = new ProjectDAO();

    private final PropertyChangeSupport observable;

    public CheckProfileDataAccess() {
        this.observable = new PropertyChangeSupport(this);
    }
//
//    @Override
//    public List<Role> getUserRolesByUid(Integer target) {
//        return null;
//    }

    @Override
    public User getUserByUid(Integer target) {
        return userDB.getUser(target);

    }

//    @Override
//    public PropertyChangeSupport getObservable() {
//        return observable;
//    }
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
        if (dptDB.getDepartment(oid) != null){
            return dptDB.getDepartment(oid);
        } else if(projectDB.getProject(oid) != null){
            return projectDB.getProject(oid);
        } else if (taskDB.getTask(oid) != null){
            return taskDB.getTask(oid);
        }
        return null;

    }
//
//    @Override
//    public User getFakeUserByUid(Integer target) {
//        return null;
//    }

}
