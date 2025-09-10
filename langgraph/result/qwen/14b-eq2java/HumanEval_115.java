import java.lang.Math;

public class HumanEval_115 {
    public static int calculateMaxLoad(int[][] matrix, int limit) {
        int totalLoad = 0;
        for (int[] row : matrix) {
            int sum = 0;
            for (int value : row) {
                sum += value;
            }
            totalLoad += Math.ceil((double) sum / limit);
        }
        return totalLoad;
    }
}