public class HumanEval_106 {
    public static int[] f(int n) {
        int[] ret = new int[n];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                int x = 1;
                for (int j = 1; j <= i; j++) {
                    x *= j;
                }
                ret[i - 1] = x;
            } else {
                int x = 0;
                for (int j = 1; j <= i; j++) {
                    x += j;
                }
                ret[i - 1] = x;
            }
        }
        return ret;
    }
}