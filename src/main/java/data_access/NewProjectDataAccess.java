package data_access;

import DAO.DepartmentDAO;
import DAO.ProjectDAO;
import create_new_project.NewProjectGateway;
import create_new_project.NewProjectResponseModel;
import entity.Department;
import DAOInterfaces.DepartmentDAOInterface;
import DAOInterfaces.ProjectDAOInterface;

import java.util.List;

public class NewProjectDataAccess implements NewProjectGateway {

    private final DepartmentDAOInterface departmentDAOInterface = new DepartmentDAO();
    private final ProjectDAOInterface projectDAOInterface = new ProjectDAO();

    @Override
    public void save(NewProjectResponseModel responseModel) {
        projectDAOInterface.createProject(responseModel.getProject());
    }

    @Override
    public List<Department> getDptList() {
        return departmentDAOInterface.getAllDepartments();
    }

}
