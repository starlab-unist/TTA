public class HumanEval_103 {
    public static String calculateBinaryAverage(int n, int m) {
        if (m < n) {
            return "-1";
        }
        int summation = 0;
        int i = n;
        while (i <= m) {
            summation += i;
            i++;
        }
        int average = Math.round((float) summation / (m - n + 1));
        return Integer.toBinaryString(average);
    }
}