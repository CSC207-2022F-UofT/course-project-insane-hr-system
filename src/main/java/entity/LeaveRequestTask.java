package entity;

import jdk.jshell.spi.ExecutionControl;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static entity.Constants.CLOSED;

public class LeaveRequestTask extends CommonOrganization implements Task {
    private final LeaveRequestProject project;
    private boolean results;

    public LeaveRequestTask(UUID oid, String name, Integer head, Set<Integer> members, String description,
                            LocalDateTime createTime, LeaveRequestProject project) {
        super(oid, name, head, members, description, createTime);
        this.project = project;
    }

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public Object getResults() {
        return results;
    }

    @Override
    public void setResults(Object results) throws ExecutionControl.NotImplementedException {
        if (results instanceof Boolean) {
            this.results = ((Boolean) results);
        } else {
            throw new ExecutionControl.NotImplementedException("Input should be Boolean");
        }
    }

    @Override
    public void close() {
        this.setState(CLOSED);
        this.setCloseTime(LocalDateTime.now());
        project.update();
    }
}
