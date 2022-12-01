package entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class LeaveRequestProject extends CommonOrganization implements Project {
    private List<Task> tasks;
    private int numResponses = 0;
    private int vacationDays;
    private LeaveType leaveType;

    public LeaveRequestProject(UUID oid, String name, Integer head, Set<Integer> members, String description,
                               LocalDateTime createTime, int vacationDays, LeaveType leaveType) {
        super(oid, name, head, members, description, createTime);
        this.vacationDays = vacationDays;
        this.leaveType = leaveType;
    }

    public LeaveRequestProject(UUID oid, String name, Integer head, Set<Integer> members, String description,
                               LocalDateTime createTime, LocalDateTime closeTime, int vacationDays, LeaveType leaveType) {
        super(oid, name, head, members, description, createTime, closeTime);
        this.vacationDays = vacationDays;
        this.leaveType = leaveType;
    }

    @Override
    public boolean addTask(Task task) {
        return this.tasks.add(task);
    }

    @Override
    public boolean removeTask(Task task) {
        return this.tasks.remove(task);
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getNumResponses() {
        return numResponses;
    }

    public void setNumResponses(int numResponses) {
        this.numResponses = numResponses;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public void update() {
        this.numResponses += 1;
        // close the project when all responses have been gathered
        if (this.numResponses == this.getMembers().size()) {
            this.close();
        }
    }
}
