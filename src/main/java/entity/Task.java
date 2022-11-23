package entity;

import jdk.jshell.spi.ExecutionControl;

public interface Task extends Organization {
    Project getProject();

    Object getResults();

    void setResults(Object results) throws ExecutionControl.NotImplementedException;

}
