package DAOInterfaces;

import entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskDAOInterface {

    // get all tasks //
    public List<Task> getAllTasks();

    // get one task //
    public Task getTask(UUID id);

    // create a task //
    public void createTask(Task task);

    // update a task //
    public void updateTask(Task task);
}
