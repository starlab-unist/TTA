import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_123 {
    public static List<Integer> getOddCollatz(int startingValue) {
        List<Integer> oddCollatz = new ArrayList<>();

        if (startingValue % 2 != 0) {
            oddCollatz.add(startingValue);
        }

        int currentValue = startingValue;
        while (currentValue > 1) {
            if (currentValue % 2 == 0) {
                currentValue /= 2;
            } else {
                currentValue = currentValue * 3 + 1;
            }

            if (currentValue % 2 != 0) {
                oddCollatz.add(currentValue);
            }
        }

        Collections.sort(oddCollatz);
        return oddCollatz;
    }
}