package Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    final int uid;
    String username;
    List<String> roles;
    Department dpt;
    String bio;
    String status;
    UserFile userFile;

    //constructors
    //construct the initial uid
    public User(int uid) {
        this.uid = uid;
    }
    // construct without UserFile
    public User(int uid, String username, ArrayList<String> roles, Department dpt, String bio, String status) {
        this.uid = uid;
        this.username = username;
        this.roles = roles;
        this.dpt = dpt;
        this.bio = bio;
        this.status = status;
    }

    //construct with UserFile
    public User(int uid, String username, ArrayList<String> roles, Department dpt, String bio, String status, UserFile userFile) {
        this.uid = uid;
        this.username = username;
        this.roles = roles;
        this.dpt = dpt;
        this.bio = bio;
        this.status = status;
        this.userFile = userFile;
    }


    // abstract methods
    public abstract UserFile getUserFile();

    public abstract List<String> getAuthorityDomain();

    public abstract UserFile getFile();

    // getters and setters
    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Department getDpt() {
        return dpt;
    }

    public void setDpt(Department dpt) {
        this.dpt = dpt;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
