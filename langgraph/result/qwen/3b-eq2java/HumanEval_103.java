public class HumanEval_103 {

    public static String calculateBinaryAverage(int start, int end) {
        if (end < start) {
            return "-1";
        }
        
        int totalSum = 0;
        int current = start;
        
        // Calculate the sum of numbers from start to end
        while (current <= end) {
            totalSum += current;
            current++;
        }
        
        // Calculate the average and round it
        int average = (int) Math.round((double) totalSum / (end - start + 1));
        
        // Convert the average to binary
        return Integer.toBinaryString(average);
    }
}