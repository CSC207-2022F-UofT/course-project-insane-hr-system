package entity;

import java.io.Serializable;

public interface UserFace extends Serializable {
    void setName(String name);

    String getName();

    Department getDpt();

    void setDpt(Department dpt);

    String getBio();

    void setBio(String bio);

    // getter and setter for Fields in the UserFile
    Integer getId();
}
