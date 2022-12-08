package data_access;


import DAO.DepartmentDAO;
import DAO.ProjectDAO;
import DAO.TaskDAO;
import DAO.UserDAO;
import DAOInterfaces.DepartmentDAOInterface;
import DAOInterfaces.ProjectDAOInterface;
import DAOInterfaces.TaskDAOInterface;
import DAOInterfaces.UserDAOInterface;
import check_profile_validation.CheckProfileIGateway;
import entity.Department;
import entity.Organization;
import entity.Role;
import entity.User;
import my_dao.dptDao;
import my_dao.projectDao;
import my_dao.taskDao;
import my_dao.userDao;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.UUID;

public class CheckProfileDataAccess implements CheckProfileIGateway {
//TODO: implement this gateway.

    private final DepartmentDAOInterface departmentDAO = new DepartmentDAO();
    private final UserDAOInterface userDAOInterface = new UserDAO();
    private final TaskDAOInterface taskDAOInterface = new TaskDAO();
    private final ProjectDAOInterface projectDAOInterface = new ProjectDAO();

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
        return userDAOInterface.getUser(target);
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
//            departmentDAO.getDepartment(oid);
        return null;
    }
//
//    @Override
//    public User getFakeUserByUid(Integer target) {
//        return null;
//    }

}
