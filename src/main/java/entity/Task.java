package entity;

public interface Task extends Organization {
    Project getProject();

    Object getResults();

    void setResults(Object results);

}
