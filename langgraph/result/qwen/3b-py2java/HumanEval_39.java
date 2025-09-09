public class HumanEval_39 {

    public static int primeFib(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be a positive integer.");
        }

        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];

            if (isPrime(fib[i])) {
                n--;
            }
        }

        return fib[n - 1];
    }

    private static boolean isPrime(int p) {
        if (p < 2) {
            return false;
        }
        for (int k = 2; k <= Math.sqrt(p); k++) {
            if (p % k == 0) {
                return false;
            }
        }
        return true;
    }
}