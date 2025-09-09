public class HumanEval_115 {

    public static int calculateMaxLoad(int[][] matrix, int limit) {
        int totalLoad = 0;
        for (int[] row : matrix) {
            totalLoad += (int) Math.ceil((double) Arrays.stream(row).sum() / limit);
        }
        return totalLoad;
    }

}