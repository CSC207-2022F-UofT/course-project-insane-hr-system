package entity.task;

import entity.CommonOrganization;
import entity.project.LeaveRequestProject;
import entity.project.Project;

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

    public LeaveRequestTask(UUID oid, String name, Integer head, Set<Integer> members, String description,
                            LocalDateTime createTime, LocalDateTime closeTime, LeaveRequestProject project) {
        super(oid, name, head, members, description, createTime, closeTime);
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
    public void setResults(Object results) {
        this.results = (boolean) results;
    }

    @Override
    public void close() {
        this.setState(CLOSED);
        this.setCloseTime(LocalDateTime.now());
        project.update();
    }

    public String getType(){
        return "LEAVE";
    }

}
