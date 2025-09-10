import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanEval_126 {
    public static boolean isSorted(List<Integer> lst) {
        Map<Integer, Integer> countDigit = new HashMap<>();
        for (int i : lst) {
            countDigit.put(i, countDigit.getOrDefault(i, 0) + 1);
        }
        for (int i : lst) {
            if (countDigit.get(i) > 2) {
                return false;
            }
        }
        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(i - 1) > lst.get(i)) {
                return false;
            }
        }
        return true;
    }
}