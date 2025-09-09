public class HumanEval_59 {
    public static int largestPrimeFactor(int n) {
        int largest = 1;
        for (int j = 2; j <= n; j++) {
            if (n % j == 0 && isPrime(j)) {
                largest = Math.max(largest, j);
            }
        }
        return largest;
    }

    private static boolean isPrime(int k) {
        if (k < 2) {
            return false;
        }
        for (int i = 2; i < k; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}