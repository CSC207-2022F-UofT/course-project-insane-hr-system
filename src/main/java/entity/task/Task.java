package entity.task;

import entity.Organization;
import entity.project.Project;

public interface Task extends Organization {
    Project getProject();

    Object getResults();

    void setResults(Object results);

}
