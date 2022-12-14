package entity.project;

import java.util.Set;

public interface ProjectBuilder {
    Project createProject(String projectName, String description, Set<Integer> members, int vacationDays, LeaveType leaveType);
}
