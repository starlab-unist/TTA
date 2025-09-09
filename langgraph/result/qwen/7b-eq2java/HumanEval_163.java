import java.util.ArrayList;
import java.util.List;

public class HumanEval_163 {
    public List<Integer> generateIntegers(int a, int b) {
        int lower = Math.max(2, Math.min(a, b));
        int upper = Math.min(8, Math.max(a, b));

        List<Integer> counts = new ArrayList<>();
        for (int current = lower; current <= upper; current++) {
            if (current % 2 == 0) {
                counts.add(current);
            }
        }

        return counts;
    }
}