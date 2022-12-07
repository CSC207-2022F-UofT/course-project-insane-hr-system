package my_dao;

import DAOInterfaces.TaskDAOInterface;
import entity.Task;

import java.util.List;
import java.util.UUID;

public class taskDao implements TaskDAOInterface {
    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public Task getTask(UUID id) {
        return null;
    }

    @Override
    public void createTask(Task task) {

    }

    @Override
    public void updateTask(Task task) {

    }
}
