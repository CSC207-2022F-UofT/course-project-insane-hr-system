package entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static entity.Constants.CLOSED;
import static entity.Constants.OPEN;

public class CommonOrganization implements Organization {
    private final int oid;
    private String name;
    private Integer head;
    private Set<UUID> members;
    private String description;
    private final LocalDateTime creatTime;
    private LocalDateTime closeTime;
    private String state;

    //construction a CLOSED organization
    public CommonOrganization(int oid, String name,
                              Integer head, Set<UUID> members,
                              String description,
                              LocalDateTime creatTime, LocalDateTime closeTime) {
        this.oid = oid;
        this.name = name;
        this.head = head;
        this.members = members;
        this.description = description;
        this.creatTime = creatTime;
        this.closeTime = closeTime;
        this.state = CLOSED;
    }

    // construct an OPEN organization
    public CommonOrganization(int oid, String name,
                              Integer head, Set<UUID> members,
                              String description,
                              LocalDateTime creatTime) {
        this.oid = oid;
        this.name = name;
        this.head = head;
        this.members = members;
        this.description = description;
        this.creatTime = creatTime;
        this.state = OPEN;
    }

    //opening and closing the Organization
    @Override
    public void close() {
        this.state = CLOSED;
        this.closeTime = LocalDateTime.now();
    }

    @Override
    public void open() {
        this.state = OPEN;
        this.closeTime = null;
    }


    // add remove members.
    @Override
    public boolean addMember(UUID uid) {
        return this.members.add(uid);
    }

    @Override
    public boolean removeMember(UUID uid) {
        return this.members.remove(uid);
    }

    // getters and setters

    @Override
    public int getOid() {
        return oid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getHead() {
        return head;
    }

    @Override
    public void setHead(Integer head) {
        this.head = head;
    }

    @Override
    public Set<UUID> getMembers() {
        return members;
    }

    @Override
    public void setMembers(Set<UUID> members) {
        this.members = members;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public LocalDateTime getCreatTime() {
        return creatTime;
    }

    @Override
    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    @Override
    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }
}
