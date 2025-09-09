public class HumanEval_150 {
    public static int determineValueBasedOnDivisibility(int n, int x, int y) {
        if (n == 1) {
            return y;
        }

        int divisor = 2;
        while (divisor < n) {
            if (n % divisor == 0) {
                return y;
            }
            divisor++;
        }
        return x;
    }
}