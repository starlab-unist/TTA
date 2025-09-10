import java.util.HashMap;
import java.util.Map;

public class HumanEval_126 {
    public static boolean check_sorted_sequence(int[] sequence) {
        Map<Integer, Integer> digitCount = new HashMap<>();
        for (int num : sequence) {
            digitCount.put(num, digitCount.getOrDefault(num, 0) + 1);
        }
        
        for (int num : sequence) {
            if (digitCount.get(num) > 2) {
                return false;
            }
        }
        
        int index = 1;
        while (index < sequence.length) {
            if (sequence[index - 1] > sequence[index]) {
                return false;
            }
            index += 1;
        }
        
        return true;
    }
}