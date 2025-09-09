import java.util.ArrayList;
import java.util.List;

public class HumanEval_46 {
    public static int fib4(int n) {
        List<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(2);
        results.add(0);

        if (n < 4) {
            return results.get(n);
        }

        for (int i = 4; i <= n; i++) {
            results.add(results.get(i - 1) + results.get(i - 2) + results.get(i - 3) + results.get(i - 4));
            results.remove(0);
        }

        return results.get(results.size() - 1);
    }
}