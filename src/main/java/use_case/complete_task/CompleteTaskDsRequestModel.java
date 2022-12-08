

package use_case.complete_task;
import entity.task.Task;
public class CompleteTaskDsRequestModel {
    private Task task;

    public CompleteTaskDsRequestModel(Task task) {
        this.task =task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
