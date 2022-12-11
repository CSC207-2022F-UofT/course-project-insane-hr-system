package entity;

import entity.project.LeaveRequestProject;
import entity.task.LeaveRequestTask;
import entity.project.LeaveType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static entity.Constants.CLOSED;
import static entity.Constants.OPEN;
import static org.junit.jupiter.api.Assertions.*;

class LeaveRequestTaskTest {
    LeaveRequestProject project;
    LeaveRequestTask task;
    LeaveRequestTask task2;

    @BeforeEach
    public void setup() {
        Set<Integer> m = new HashSet<>(Arrays.asList(2, 3));
        Department dpt = new Department(UUID.randomUUID(), "dpt", 2, m, "des", LocalDateTime.now());
        project = new LeaveRequestProject(UUID.randomUUID(), "Project", 1,
                m, "...", LocalDateTime.now(), 14, LeaveType.VACATION, dpt);
        task = new LeaveRequestTask(UUID.randomUUID(), "Task", 2, new HashSet<>(),
                "...", LocalDateTime.now(), project);
        task2 = new LeaveRequestTask(UUID.randomUUID(), "Task", 3, new HashSet<>(),
                "...", LocalDateTime.now(), project);
        project.addTask(task);
        project.addTask(task2);
    }

    @Test
    void testTaskCloseProjectUpdate() {
        task.close();
        assertSame(CLOSED, task.getState());
        assertEquals(1, project.getNumResponses());
        assertSame(OPEN, project.getState());
    }

    @Test
    void testTaskCloseProjectClose() {
        task.close();
        task2.close();
        assertEquals(2, project.getNumResponses());
        assertSame(CLOSED, project.getState());
    }

    @AfterEach
    public void cleanup() {
        task.open();
        task2.open();
        project.open();
        project.setVacationDays(0);
    }
}