public class HumanEval_46 {
    public static int fib4(int n) {
        int[] results = {0, 0, 2, 0};
        if (n < 4) {
            return results[n];
        }

        for (int i = 4; i <= n; i++) {
            results[i % 4] = results[(i - 1) % 4] + results[(i - 2) % 4] + results[(i - 3) % 4] + results[(i - 4) % 4];
        }

        return results[n % 4];
    }
}