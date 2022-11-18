package entity;

import java.io.Serializable;
import java.util.UUID;

public interface UserFace extends Serializable {
    void setName(String name);

    String getName();

    Department getDpt();

    void setDpt(Department dpt);

    String getBio();

    void setBio(String bio);

    // getter and setter for Fields in the UserFile
    UUID getId();
}
