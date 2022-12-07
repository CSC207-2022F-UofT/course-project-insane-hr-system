package DAOInterfaces;

import entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskDAOInterface {

    // get all tasks //
    List<Task> getAllTasks();

    // get one task //
    Task getTask(UUID id);

    // create a task //
    void createTask(Task task);

    // update a task //
    void updateTask(Task task);
}
