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

}

//    Set<Integer> s = new HashSet<>();
//    Department dpt1 = new Department(UUID.randomUUID(),"dpta",2,s,"NOTHING", LocalDateTime.now());
//    Department dpt2 = new Department(UUID.randomUUID(),"dptb",2,s,"NOTHING", LocalDateTime.now());
//    Department dpt3 = new Department(UUID.randomUUID(),"dptc",2,s,"NOTHING", LocalDateTime.now());
//    List<Department> dpts = new ArrayList<>();
//        dpts.add(dpt1);
//                dpts.add(dpt2);
//                dpts.add(dpt3);
//                return dpts;
