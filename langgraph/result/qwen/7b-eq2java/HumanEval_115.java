public class HumanEval_115 {
    public static int calculateMaxLoad(int[][] matrix, double limit) {
        int totalLoad = 0;
        for (int[] row : matrix) {
            double sum = 0;
            for (int value : row) {
                sum += value;
            }
            totalLoad += Math.ceil(sum / limit);
        }
        return totalLoad;
    }
}