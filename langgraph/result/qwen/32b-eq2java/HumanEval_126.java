import java.util.HashMap;
import java.util.Map;

class HumanEval_126 {
    public boolean checkSortedSequence(int[] sequence) {
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
            index++;
        }
        
        return true;
    }
}