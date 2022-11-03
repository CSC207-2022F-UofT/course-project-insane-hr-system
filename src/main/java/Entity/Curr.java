package Entity;

public class Curr {
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Curr.user = user;
    }
}
