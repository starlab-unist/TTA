public class HumanEval_46 {
    public static int fib4(int n) {
        int[] results = {0, 0, 2, 0};
        if (n < 4) {
            return results[n];
        }

        for (int i = 4; i <= n; i++) {
            int nextValue = results[3] + results[2] + results[1] + results[0];
            results[0] = results[1];
            results[1] = results[2];
            results[2] = results[3];
            results[3] = nextValue;
        }

        return results[3];
    }
}