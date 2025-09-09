import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_123 {
    public List<Integer> getOddCollatz(int n) {
        List<Integer> oddCollatz;
        if (n % 2 == 0) {
            oddCollatz = new ArrayList<>();
        } else {
            oddCollatz = new ArrayList<>();
            oddCollatz.add(n);
        }
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }

            if (n % 2 == 1) {
                oddCollatz.add(n);
            }
        }

        Collections.sort(oddCollatz);
        return oddCollatz;
    }
}