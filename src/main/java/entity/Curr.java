package entity;

public class Curr {
    private static User user;
    private static Integer lastUid;
    private static Integer lastOid;

    public static void incrementUid() {
        lastUid += 1;
    }

    public static void incrementOid() {
        lastOid += 1;
    }
    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Curr.user = user;
    }

    public static Integer getLastUid() {
        return lastUid;
    }

    public static void setLastUid(Integer lastUid) {
        Curr.lastUid = lastUid;
    }

    public static Integer getLastOid() {
        return lastOid;
    }

    public static void setLastOid(Integer lastOid) {
        Curr.lastOid = lastOid;
    }
}
