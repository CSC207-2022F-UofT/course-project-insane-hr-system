package entity.leave_request;

import entity.LeaveRequestProject;
import entity.LeaveRequestTask;
import entity.LeaveType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static entity.Constants.CLOSED;
import static org.junit.jupiter.api.Assertions.*;

class LeaveRequestTaskTest {

    @Test
    void testTaskCloseProjectUpdate() {
        Set<Integer> m = new HashSet<>(Arrays.asList(2, 3));
        LeaveRequestProject project = new LeaveRequestProject(UUID.randomUUID(), "Project", 1,
                m, "...", LocalDateTime.now(), 14, LeaveType.VACATION);
        LeaveRequestTask task = new LeaveRequestTask(UUID.randomUUID(), "Task", 2, new HashSet<>(),
                "...", LocalDateTime.now(), project);
        task.close();

        assertSame(task.getState(), CLOSED);
        assertNotNull(task.getCloseTime());
        assertEquals(1, project.getNumResponses());
    }

    @Test
    void testTaskCloseProjectClose() {
        Set<Integer> m = new HashSet<>(List.of(2));
        LeaveRequestProject project = new LeaveRequestProject(UUID.randomUUID(), "Project", 1,
                m, "...", LocalDateTime.now(), 14, LeaveType.VACATION);
        LeaveRequestTask task = new LeaveRequestTask(UUID.randomUUID(), "Task", 2, new HashSet<>(),
                "...", LocalDateTime.now(), project);
        task.close();

        assertSame(project.getState(), CLOSED);
    }
}