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
    boolean addMember(UUID uid);

    boolean removeMember(UUID uid);

    int getOid();

    String getName();

    void setName(String name);

    Integer getHead();

    void setHead(Integer head);

    Set<UUID> getMembers();

    void setMembers(Set<UUID> members);

    String getDescription();

    void setDescription(String description);

    LocalDateTime getCreatTime();

    LocalDateTime getCloseTime();

    void setCloseTime(LocalDateTime closeTime);

    String getState();

    void setState(String state);
}
