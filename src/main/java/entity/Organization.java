package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public interface Organization extends Serializable {
    //opening and closing the Organization
    void close();

    void open();

    // add remove members.
    boolean addMember(Integer uid);

    boolean removeMember(Integer uid);

    UUID getOid();

    String getName();

    void setName(String name);

    Integer getHead();

    void setHead(Integer head);

    Set<Integer> getMembers();

    void setMembers(Set<Integer> members);

    String getDescription();

    void setDescription(String description);

    LocalDateTime getCreateTime();

    LocalDateTime getCloseTime();

    void setCloseTime(LocalDateTime closeTime);

    String getState();

    void setState(String state);
}
