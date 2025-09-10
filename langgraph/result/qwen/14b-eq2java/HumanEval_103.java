public class HumanEval_103 {
    public static String calculateBinaryAverage(int start, int end) {
        if (end < start) {
            return "-1";
        }
        int totalSum = 0;
        int current = start;
        while (current <= end) {
            totalSum += current;
            current += 1;
        }
        int average = Math.round((float) totalSum / (end - start + 1));
        return Integer.toBinaryString(average);
    }
}