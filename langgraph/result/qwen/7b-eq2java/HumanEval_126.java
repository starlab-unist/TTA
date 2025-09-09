import java.util.HashMap;
import java.util.Map;

public class HumanEval_126 {
    public static boolean checkSortedSequence(int[] sequence) {
        Map<Integer, Integer> digitCount = new HashMap<>();
        for (int number : sequence) {
            digitCount.put(number, digitCount.getOrDefault(number, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : digitCount.entrySet()) {
            if (entry.getValue() > 2) {
                return false;
            }
        }
        
        int index = 1;
        while (index < sequence.length) {
            if (sequence[index - 1] > sequence[index]) {
                return false;
            }
            index++;
        }
        
        return true;
    }
}