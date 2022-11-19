package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

public interface Organization extends Serializable {
    //opening and closing the Organization
    void close();

    void open();

    // add remove members.
    boolean addMember(Integer uid);

    boolean removeMember(Integer uid);

    int getOid();

    String getName();

    void setName(String name);

    Integer getHead();

    void setHead(Integer head);

    Set<Integer> getMembers();

    void setMembers(Set<Integer> members);

    String getDescription();

    void setDescription(String description);

    LocalDateTime getCreatTime();

    LocalDateTime getCloseTime();

    void setCloseTime(LocalDateTime closeTime);

    String getState();

    void setState(String state);
}
