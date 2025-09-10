public class HumanEval_103 {
    public static String roundedAvg(int n, int m) {
        if (m < n) {
            return "-1";
        }
        int summation = 0;
        for (int i = n; i <= m; i++) {
            summation += i;
        }
        return Integer.toBinaryString((int) Math.round((double) summation / (m - n + 1)));
    }
}