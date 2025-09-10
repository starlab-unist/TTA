import java.util.ArrayList;
import java.util.List;

public class HumanEval_39 {

    public static int primeFib(int n) {
        List<Integer> f = new ArrayList<>();
        f.add(0);
        f.add(1);

        while (true) {
            f.add(f.get(f.size() - 1) + f.get(f.size() - 2));
            if (isPrime(f.get(f.size() - 1))) {
                n -= 1;
            }
            if (n == 0) {
                return f.get(f.size() - 1);
            }
        }
    }

    private static boolean isPrime(int p) {
        if (p < 2) {
            return false;
        }
        for (int k = 2; k <= Math.min((int) Math.sqrt(p), p - 1); k++) {
            if (p % k == 0) {
                return false;
            }
        }
        return true;
    }
}