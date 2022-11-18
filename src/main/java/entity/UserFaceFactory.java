package entity;

import java.util.UUID;

public interface UserFaceFactory {
    UserFace create(UUID uid);
    UserFace create(UUID uid, Department dpt, String bio, String name);
}
