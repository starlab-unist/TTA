import java.lang.Math;

public class HumanEval_115 {
    public int calculateMaxLoad(int[][] matrix, int limit) {
        int totalLoad = 0;
        for (int[] row : matrix) {
            totalLoad += Math.ceil((double) sumArray(row) / limit);
        }
        return totalLoad;
    }

    private int sumArray(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}