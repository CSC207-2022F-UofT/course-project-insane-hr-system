package enroll_employee;

public class test {
    public enum Position {
        CEO,
        HEAD,
        // This are special position for test.
        SAMEPROJECT, SAMEORG, HEADOF, HASOVERLAPORG, MEMBER
    }

    public static Position getPosition(String s){
        return Position.valueOf(s);
    }

    public static void main(String[] args) {
        String s="HEAD";
        Position p = test.getPosition(s);
    }

}
