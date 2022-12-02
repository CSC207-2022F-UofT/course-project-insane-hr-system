import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        System.out.println(integerList);
        integerList.add(null);
        System.out.println(integerList);
    }
}
