public class HumanEval_103 {
    public static String roundedAvg(int n, int m) {
        if (m < n) {
            return "-1";
        }
        int summation = 0;
        for (int i = n; i <= m; i++) {
            summation += i;
        }
        int average = Math.round((float) summation / (m - n + 1));
        return Integer.toBinaryString(average);
    }
}