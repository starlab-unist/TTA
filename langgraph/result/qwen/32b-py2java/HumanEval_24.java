public class HumanEval_24 {
    public int largestDivisor(int n) {
        for (int i = n - 1; i > 0; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return 0; // In case no divisor is found, though for n > 0, this should not happen
    }
}