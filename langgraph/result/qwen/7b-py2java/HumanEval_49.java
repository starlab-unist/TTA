public class HumanEval_49 {
    public static int modp(int n, int p) {
        int ret = 1;
        for (int i = 0; i < n; i++) {
            ret = (2 * ret) % p;
        }
        return ret;
    }
}