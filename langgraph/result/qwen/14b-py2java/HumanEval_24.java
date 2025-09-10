public class HumanEval_24 {
    public static int largestDivisor(int n) {
        for (int i = n - 1; i > 0; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1; // If no divisor is found, return 1 (since every number is divisible by 1)
    }
}