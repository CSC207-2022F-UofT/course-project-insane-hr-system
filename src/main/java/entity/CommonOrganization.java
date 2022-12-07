package entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static entity.Constants.CLOSED;
import static entity.Constants.OPEN;

public class CommonOrganization implements Organization {
    private final UUID oid;
    private String name;
    private Integer head;
    private Set<Integer> members = new HashSet<>();
    private String description;
    private final LocalDateTime createTime;
    private LocalDateTime closeTime;
    private String state;

    public CommonOrganization(UUID oid, String name, Integer head, String description, LocalDateTime createTime) {
        this.oid = oid;
        this.name = name;
        this.head = head;
        this.description = description;
        this.createTime = createTime;
        this.state = CLOSED;
        this.members.add(head);
    }

    //construction a CLOSED organization
    public CommonOrganization(UUID oid, String name,
                              Integer head, Set<Integer> members,
                              String description,
                              LocalDateTime createTime, LocalDateTime closeTime) {
        this.oid = oid;
        this.name = name;
        this.head = head;
        this.members = members;
        this.description = description;
        this.createTime = createTime;
        this.closeTime = closeTime;
        this.state = CLOSED;
        this.members.add(head);
    }

    // construct an OPEN organization
    public CommonOrganization(UUID oid, String name,
                              Integer head, Set<Integer> members,
                              String description,
                              LocalDateTime createTime) {
        this.oid = oid;
        this.name = name;
        this.head = head;
        this.members = members;
        this.description = description;
        this.createTime = createTime;
        this.state = OPEN;
        this.members.add(head);
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
    public boolean addMember(Integer uid) {
        return this.members.add(uid);
    }

    @Override
    public boolean removeMember(Integer uid) {
        return this.members.remove(uid);
    }

    // getters and setters

    @Override
    public UUID getOid() {
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
    public Set<Integer> getMembers() {
        return members;
    }

    @Override
    public void setMembers(Set<Integer> members) {
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
    public LocalDateTime getCreateTime() {
        return createTime;
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

    /**
     * @param obj any object.
     * @return true if the oid are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Organization) {
            return this.getOid().equals((((Organization) obj).getOid()));
        }
        return false;
    }

    public String getType(){
        return "ORG";
    }

    @Override
    public String toString() {
        return "CommonOrganization{" + '\n' +
                "oid=" + oid +'\n' +
                ", name='" + name + '\'' +'\n' +
                ", head=" + head +'\n' +
                ", members=" + members +'\n' +
                ", description='" + description + '\'' +'\n' +
                ", createTime=" + createTime +'\n' +
                ", closeTime=" + closeTime +'\n' +
                ", state='" + state + '\'' +'\n' +
                '}';
    }
}
