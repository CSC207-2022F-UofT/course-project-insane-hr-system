package entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CommonTaskFactory implements CommonTaskFactoryInterface{

    @Override
    public CommonTask createTask(String taskName, String description, CommonUser employee, CommonProject project) {
        UUID newid = UUID.randomUUID();
        int head = Curr.getUser().getId();
        Set<Integer> members = new HashSet<>();
        members.add(employee.getId());
        LocalDateTime creationTime = LocalDateTime.now();

        CommonTask newTask = new CommonTask(newid, taskName, head, members, description, creationTime, project);

        return newTask;
    }
}