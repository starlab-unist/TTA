public class HumanEval_83 {
    public static int startsOneEnds(int n) {
        if (n == 1) return 1;
        return 18 * (int) Math.pow(10, n - 2);
    }
}