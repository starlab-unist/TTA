public class HumanEval_115 {

    public static int maxFill(int[][] grid, int capacity) {
        int totalFills = 0;
        for (int[] arr : grid) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            totalFills += (int) Math.ceil((double) sum / capacity);
        }
        return totalFills;
    }

}