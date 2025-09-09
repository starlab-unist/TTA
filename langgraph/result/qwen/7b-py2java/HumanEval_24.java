public class HumanEval_24 {
    public static int largestDivisor(int n) {
        for (int i = n - 1; i > 0; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1; // If no divisor found other than 1, return 1
    }
}