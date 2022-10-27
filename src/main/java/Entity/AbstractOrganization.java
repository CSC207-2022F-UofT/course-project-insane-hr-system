package Entity;

import java.util.List;

import static Entity.Constants.CLOSED;
import static Entity.Constants.OPEN;

public abstract class AbstractOrganization {
    String name;
    int star;
    User head;
    List<User> members;
    String creatTime;
    String closeTime;
    String description;
    String state;

    public AbstractOrganization(String name,
                                int star,
                                User head,
                                List<User> members,
                                String creatTime,
                                String closeTime,
                                String description) {
        this.name = name;
        this.star = star;
        this.head = head;
        this.members = members;
        this.creatTime = creatTime;
        this.closeTime = closeTime;
        this.description = description;
        this.state = OPEN;

    }

    //opening and closing the Organization
    public void close() {
        this.state = CLOSED;
    }

    public void open() {
        this.state = OPEN;
    }


    // getters and setters
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

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
