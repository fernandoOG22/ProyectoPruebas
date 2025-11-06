import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> right = Arrays.asList(1, 2, 3);
        List<Integer> left = Arrays.asList(1, 1, 1);
        System.out.println(new addArrays().add(left, right));
    }
}
