import java.util.ArrayList;
import java.util.List;

public class HumanEval_163 {
    public static List<Integer> produceEvenNumbers(int x, int y) {
        int start = Math.max(2, Math.min(x, y));
        int end = Math.min(8, Math.max(x, y));

        List<Integer> evenNumbers = new ArrayList<>();
        int current = start;
        while (current <= end) {
            if (current % 2 == 0) {
                evenNumbers.add(current);
            }
            current += 1;
        }

        return evenNumbers;
    }
}