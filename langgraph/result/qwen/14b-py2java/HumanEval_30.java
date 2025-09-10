import java.util.ArrayList;
import java.util.List;

public class HumanEval_30 {
    public static List<Integer> getPositive(List<Integer> l) {
        List<Integer> result = new ArrayList<>();
        for (Integer e : l) {
            if (e > 0) {
                result.add(e);
            }
        }
        return result;
    }
}