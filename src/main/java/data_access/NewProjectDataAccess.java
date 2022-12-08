package data_access;

import DAO.DepartmentDAO;
import DAO.ProjectDAO;
import use_case.create_new_project.NewProjectGateway;
import use_case.create_new_project.NewProjectResponseModel;
import entity.Department;
import DAO.DepartmentDAOInterface;
import DAO.ProjectDAOInterface;
import entity.Project;

import java.util.List;
import java.util.UUID;

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

    @Override
    public Project getProject(UUID uid) {
        return projectDAOInterface.getProject(uid);
    }

}
