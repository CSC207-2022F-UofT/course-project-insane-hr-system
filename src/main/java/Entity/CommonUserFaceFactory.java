package Entity;

public class CommonUserFaceFactory implements UserFaceFactory {
    @Override
    public UserFace create(int uid) {
        return new CommonUserFace(uid);
    }

    @Override
    public UserFace create(int uid, Department dpt, String bio, String name) {
        return new CommonUserFace(uid, dpt, bio, name);
    }
}
