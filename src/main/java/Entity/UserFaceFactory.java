package Entity;

public interface UserFaceFactory {
    UserFace create(int uid);
    UserFace create(int uid, Department dpt, String bio, String name);
}
