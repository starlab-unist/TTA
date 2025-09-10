import java.util.ArrayList;
import java.util.List;

public class HumanEval_42 {
    public static List<Integer> incrList(List<Integer> l) {
        List<Integer> result = new ArrayList<>();
        for (Integer e : l) {
            result.add(e + 1);
        }
        return result;
    }
}