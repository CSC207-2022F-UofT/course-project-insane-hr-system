package entity;

import java.util.UUID;

public class CommonUserFaceFactory implements UserFaceFactory {
    @Override
    public UserFace create(UUID uid) {
        return new CommonUserFace(uid);
    }

    @Override
    public UserFace create(UUID uid, Department dpt, String bio, String name) {
        return new CommonUserFace(uid, dpt, bio, name);
    }
}
