public class HumanEval_103 {
    public static String roundedAvg(int n, int m) {
        if (m < n) {
            return "-1";
        }
        long summation = 0;
        for (int i = n; i <= m; i++) {
            summation += i;
        }
        double average = summation / (double) (m - n + 1);
        return Integer.toBinaryString((int) Math.round(average));
    }
}