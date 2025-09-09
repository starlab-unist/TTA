import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_123 {
    public static ArrayList<Integer> getOddCollatz(int n) {
        ArrayList<Integer> oddCollatz = new ArrayList<>();
        if (n % 2 != 0) {
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