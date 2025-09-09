import java.util.HashMap;
import java.util.Map;

public class HumanEval_126 {
    public static boolean isSorted(int[] lst) {
        Map<Integer, Integer> countDigit = new HashMap<>();
        for (int i : lst) {
            countDigit.put(i, countDigit.getOrDefault(i, 0) + 1);
        }
        for (int value : countDigit.values()) {
            if (value > 2) {
                return false;
            }
        }
        for (int i = 1; i < lst.length; i++) {
            if (lst[i - 1] > lst[i]) {
                return false;
            }
        }
        return true;
    }
}