public class HumanEval_75 {
    public static boolean isMultiplyPrime(int a) {
        for (int i = 2; i <= 100; i++) {
            if (!isPrime(i)) continue;
            for (int j = 2; j <= 100; j++) {
                if (!isPrime(j)) continue;
                for (int k = 2; k <= 100; k++) {
                    if (!isPrime(k)) continue;
                    if (i * j * k == a) return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int n) {
        for (int j = 2; j < n; j++) {
            if (n % j == 0) return false;
        }
        return true;
    }
}