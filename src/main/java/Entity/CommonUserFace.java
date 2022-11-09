package Entity;

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
    public Integer getId() {
        return this.uid;
    }
}
