import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_123 {
    public static ArrayList<Integer> getOddCollatz(int n) {
        ArrayList<Integer> oddCollatz = new ArrayList<>();
        if (n % 2 == 0) {
            // Do nothing
        } else {
            oddCollatz.add(n);
        }

        int currentValue = n;
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