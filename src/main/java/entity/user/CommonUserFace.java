package entity.user;

import entity.Department;

public class CommonUserFace implements UserFace {
    protected final int uid;
    protected Department dpt;
    protected String bio;
    protected String name;

    public CommonUserFace(int uid) {
        this.uid = uid;
    }

    public CommonUserFace(int uid, Department dpt, String bio, String name) {
        this.uid = uid;
        this.dpt = dpt;
        this.bio = bio;
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Department getDpt() {
        return dpt;
    }

    @Override
    public void setDpt(Department dpt) {
        this.dpt = dpt;
    }

    @Override
    public String getBio() {
        return bio;
    }

    @Override
    public void setBio(String bio) {
        this.bio = bio;
    }

    // getter and setter for Fields in the UserFile
    @Override
    public int getId() {
        return this.uid;
    }

    /**
     * @param obj any object.
     * @return true if the uid are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserFace) {
            return this.getId() == ((UserFace) obj).getId();
        } else if (obj instanceof UserFile) {
            return this.getId() == ((UserFile) obj).getId();
        }
        return false;
    }

    @Override
    public String toString() {
        return "CommonUserFace{" +
                "uid=" + uid +
                ", dpt=" + dpt +
                ", bio='" + bio + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
