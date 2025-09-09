public class HumanEval_84 {
    public static String solve(int N) {
        int sum = 0;
        while (N > 0) {
            sum += N % 10;
            N /= 10;
        }
        return Integer.toBinaryString(sum);
    }
}