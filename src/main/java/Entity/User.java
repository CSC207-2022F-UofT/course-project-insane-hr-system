package Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private final int uid;
    private List<String> roles;
    private Department dpt;
    private String bio;
    private String status;
    private UserFile userFile;

    //constructors
    //construct only with the initial uid
    public User(int uid) {
        this.uid = uid;
    }
    // construct without UserFile
    public User(int uid, List<String> roles, Department dpt, String bio, String status) {
        this.uid = uid;
        // TODO: add firstName and lastName (In commonUser class?)
        this.roles = roles;
        this.dpt = dpt;
        this.bio = bio;
        this.status = status;
    }

    //construct with UserFile
    public User(int uid, ArrayList<String> roles, Department dpt, String bio, String status, UserFile userFile) {
        this.uid = uid;
        this.roles = roles;
        this.dpt = dpt;
        this.bio = bio;
        this.status = status;
        this.userFile = userFile;
    }


    // abstract methods

    public abstract List<String> getAuthorityDomain();


    //add role
    public void addRole(String role) {
        this.roles.add(role);
        //TODO: do some modification in RoleMap
    }
    public boolean removeRole(String role) {
        return this.roles.remove(role);
        // TODO: do some modification in RoleMap
    }

    // getters and setters


    public int getUid() {
        return uid;
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

    public UserFile getUserFile() {
        return this.userFile;
    }
    public void setUserFile(UserFile userFile) {
        this.userFile = userFile;
    }
}
