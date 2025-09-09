import java.util.ArrayList;
import java.util.List;

public class HumanEval_62 {
    public static List<Integer> derivative(List<Integer> xs) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < xs.size(); i++) {
            if (i > 0) {
                result.add(i * xs.get(i));
            }
        }
        return result;
    }
}