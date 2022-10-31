package Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static Entity.Constants.CLOSED;
import static Entity.Constants.OPEN;

public abstract class AbstractOrganization {
    private final int oid;
    private String name;
    private int star;
    private User head;
    private List<Integer> members;
    private String description;
    private LocalDateTime creatTime;
    private LocalDateTime closeTime;
    private String state;

    //construction a CLOSED organization
    public AbstractOrganization(int oid, String name, int star,
                                User head, List<Integer> members,
                                String description,
                                LocalDateTime creatTime, LocalDateTime closeTime) {
        this.oid = oid;
        this.name = name;
        this.star = star;
        this.head = head;
        this.members = members;
        this.description = description;
        this.creatTime = creatTime;
        this.closeTime = closeTime;
        this.state = CLOSED;
    }

    // construct an OPEN organization
    public AbstractOrganization(int oid, String name, int star,
                                User head, List<Integer> members,
                                String description,
                                LocalDateTime creatTime) {
        this.oid = oid;
        this.name = name;
        this.star = star;
        this.head = head;
        this.members = members;
        this.description = description;
        this.creatTime = creatTime;
        this.state = OPEN;
    }

    //opening and closing the Organization
    public void close() {
        this.state = CLOSED;
        this.closeTime = LocalDateTime.now();
    }

    public void open() {
        this.state = OPEN;
    }


    // add remove members. This method can only be accessed by Entity.

    boolean addMember(Integer uid) {
        return this.members.add(uid);
    }

    boolean removeMember(Integer uid) {
        return this.members.remove(uid);
    }

    // getters and setters

    public int getOid() {
        return oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public User getHead() {
        return head;
    }

    public void setHead(User head) {
        this.head = head;
    }

    public List<Integer> getMembers() {
        return members;
    }

    public void setMembers(List<Integer> members) {
        this.members = members;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDateTime creatTime) {
        this.creatTime = creatTime;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
