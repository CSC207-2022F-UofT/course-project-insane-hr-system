package use_case.review_request;

import entity.project.Project;
import entity.task.Task;

public class ReviewRequestDsRequestModel {
    private Task task;
    private Project project;
    private String status = "";

    public ReviewRequestDsRequestModel(Task task, Project project) {
        this.task = task;
        this.project = project;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
