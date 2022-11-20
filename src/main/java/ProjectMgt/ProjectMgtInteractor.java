package ProjectMgt;

import entity.Project;
import entity.Task;
import entity.User;

public class ProjectMgtInteractor {

    public Project createProject(User PM) {
        //TODO
        return null;
    }

    public boolean addTaskToProject(Project project, Task toAdd) {
        return project.addTask(toAdd);
    }

    public boolean removeTaskFromProject(Project project, Task toRemove) {
        return project.removeTask(toRemove);
    }

    public boolean addEmployeeToProject(Project project, User toAdd) {
        //TODO
        return false;
    }

    public boolean removeEmployeeFromProject(Project project, User toRemove) {
        //TODO
        return false;
    }

    public void finishProject(Project toFinish) {
        //TODO
    }

}
