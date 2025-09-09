public class HumanEval_59 {

    public static int largestPrimeFactor(int n) {
        return largestPrimeFactorHelper(n, 2);
    }

    private static int largestPrimeFactorHelper(int n, int divisor) {
        if (n <= 1) {
            return 1;
        }
        if (n % divisor == 0 && isPrime(divisor)) {
            return Math.max(divisor, largestPrimeFactorHelper(n / divisor, divisor));
        }
        return largestPrimeFactorHelper(n, divisor + 1);
    }

    private static boolean isPrime(int k) {
        if (k < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}