package project_manager_task_init_use_case;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class PMTaskInitDsRequestModel {

    private UUID oid;
    private String name;
    private int head;
    private Set<Integer> members;
    private String description;
    private LocalDateTime createTime;

    public PMTaskInitDsRequestModel(UUID oid, String name, int head, Set<Integer> members, String description, LocalDateTime createTime) {
        this.oid = oid;
        this.name = name;
        this.head = head;
        this.members = members;
        this.description = description;
        this.createTime = createTime;
    }

    public UUID getOid() {
        return this.oid;
    }

    public String getName() { return this.name; }

    public int getHead() { return this.head; }

    public Set<Integer> getMembers() { return this.members; }

    public String getDescription() { return this.description; }

    public LocalDateTime getCreateTime() {return this.createTime;}

}
